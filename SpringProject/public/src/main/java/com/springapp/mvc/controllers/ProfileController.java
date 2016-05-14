package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeBeforeLogs;
import com.springapp.mvc.aspects.annotation.IncludeSessionParameters;
import com.springapp.mvc.common.Order;
import com.springapp.mvc.common.Users;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.OrderService;
import com.springapp.mvc.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Controller
public class ProfileController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CartService cartService;

    /*
     *  Профиль покупателя
     */
    @IncludeBeforeLogs
    @IncludeSessionParameters
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String checkingProfilePage() {
        String fio = (String) request.getSession().getAttribute("fio");
        String login = (String) request.getSession().getAttribute("login");
        String email = (String) request.getSession().getAttribute("email");
        Users user = usersService.getUserByLogin(login);
        List<Order> orders = orderService.getAllOrdersByUserID(user.getId());
        request.setAttribute("allOrders", orders);
        Cookie[] cookie = request.getCookies();
        for (Cookie cook : cookie) {
            if (cook.getName().equals("mail")) {
                request.setAttribute("fio", fio);
                request.setAttribute("login", login);
                request.setAttribute("email", email);
                request.setAttribute("allOrders", orders);
            }
        }
        String sessionGoods = (String) request.getSession().getAttribute("goods");
        if (sessionGoods != null) {
            cartService.addAllGoodsFromSessionToCartOfUser(sessionGoods, user.getId());
        } else {
            request.setAttribute("cart", cartService.getCartsByUserID(user.getId()));
        }
        return "profile";
    }

    /*
     * Возвращает страницу profile
     */
    @IncludeBeforeLogs
    @IncludeSessionParameters
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String renderProfilePage() {
        String login = (String) request.getSession().getAttribute("login");
        Users user = usersService.getUserByLogin(login);
        String sessionGoods = (String) request.getSession().getAttribute("goods");
        if (sessionGoods != null) {
            cartService.addAllGoodsFromSessionToCartOfUser(sessionGoods, user.getId());
        } else {
            request.setAttribute("cart", cartService.getCartsByUserID(user.getId()));
        }
        return "profile";
    }

    /*
     * Удаление заказа у пользователя с данным ID
     */
    @IncludeSessionParameters
    @RequestMapping(value = "/delete-order/{id}", method = RequestMethod.GET)
    public String deleteOrderFromProfileByID(@PathVariable long id) {
        orderService.deleteOrderByID(id);
        return "redirect:/profile";
    }
}