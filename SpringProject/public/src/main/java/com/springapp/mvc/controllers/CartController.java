package com.springapp.mvc.controllers;

import com.springapp.mvc.common.Cart;
import com.springapp.mvc.common.Goods;
import com.springapp.mvc.common.Users;
import com.springapp.mvc.util.Methods;
import com.springapp.mvc.security.MyUserDetail;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Controller
public class CartController {


    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CartService cartService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private GoodsService goodsService;

    /*
     *  Отображение корзины с товарами
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String renderCartPage() {
        double anon_price = 0;
        double user_price = 0;
        String sessionGoods = (String) request.getSession().getAttribute("goods");

        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            List<Cart> allCarts = cartService.getCartsByUserID(user.getUser().getId());
            if (allCarts != null) {
                request.setAttribute("cart", allCarts);
                for (Cart c : allCarts) {
                    Double a = new Double(String.valueOf(c.getGoods().getPrice()));
                    user_price = user_price + (a * c.getCount());
                }
                request.setAttribute("itog", user_price);
            }
        } else {
            List<Cart> cart = cartService.getGoodsForAnonUser(sessionGoods);
            if (cart != null) {
                request.setAttribute("cart", cart);
                for (Cart c : cart) {
                    Double a = new Double(String.valueOf(c.getGoods().getPrice()));
                    anon_price = anon_price + (a * c.getCount());
                }
                request.setAttribute("itog", anon_price);
            }
        }
        if (request.getParameter("authoring") != null) {
            request.setAttribute("authoring", "auth-error");
        }
        return "cart";
    }


    /*
     *  Добавление товара в корзину по ID товара
     */
    @ResponseBody
    @RequestMapping(value = "/goods/add-to-cart/{id}", method = RequestMethod.POST)
    public String addGoodToCartFromCatalog(@PathVariable long id) {
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            cartService.addGoodInCart(id, user.getUser().getId());
            request.getSession().setAttribute("cart", cartService.getCartsByUserID(user.getUser().getId()));
        } else {
            request.getSession().setAttribute("goods", Methods.addBookInCartOfAnonUser(request, id));
        }
        return "added";
    }


    /*
     *  Удаление товара из корзины по ID товара(если их несколько, удалаются все)
     */
    @RequestMapping(value = "/delete-from-cart/{id}", method = RequestMethod.GET)
    public String deleteFromCartOneGood(@PathVariable long id) {
        Users user = usersService.getUserByLogin((String) request.getSession().getAttribute("login"));
        Goods good = goodsService.getGoodByID(id);
        if (user != null) {
            cartService.deleteGoodFromCart(good.getId(), user.getId());
        } else {
            request.getSession().setAttribute("goods", Methods.deleteGoodsFromCartOfAnonUser(request, id));
        }
        return "redirect:/cart";
    }

    /*
     *  Увеличение количества товара в корзине на 1 по ID товара, запрос идет из JS
     */
    @ResponseBody
    @RequestMapping(value = "/addAgainGood/{id}", method = RequestMethod.POST)
    public String addAgainOneGoodToCart(@PathVariable long id) throws IOException {
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            double price = 0;
            MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            cartService.addAgainOneGoodToCart(id, user.getUser().getId());
            request.setAttribute("cart", cartService.getCartsByUserID(user.getUser().getId()));
            List<Cart> allCarts = cartService.getCartsByUserID(user.getUser().getId());
            for (Cart c : allCarts) {
                Double a = new Double(String.valueOf(c.getGoods().getPrice()));
                price = price + (a * c.getCount());
            }
            request.setAttribute("itog", price);
        } else {
            request.getSession().setAttribute("goods", Methods.addAgainOneGoodToCartOfAnonUser(request, id));
        }
        return "added";
    }

    /*
     *  Уменьшение количества товара в корзине на 1 по ID товара, запрос идет из JS
     */
    @ResponseBody
    @RequestMapping(value = "/subOneGood/{id}", method = RequestMethod.POST)
    public String deleteOneGoodFromCart(@PathVariable long id) throws IOException {
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            cartService.reduceOneGoodFromCart(id, user.getUser().getId());
        } else {
            request.getSession().setAttribute("goods", Methods.reduceOneGoodFromCartOfAnonUser(request, id));

        }
        return "decreased";
    }

    @RequestMapping(value = "/order/cancel", method = RequestMethod.GET)
    public String cancelTheOrder() throws IOException {
        if (!SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            cartService.cancelOrder(user.getUser().getId());
        } else {
            request.getSession().setAttribute("goods", "");
        }
        return "redirect:/cart";
    }
}
