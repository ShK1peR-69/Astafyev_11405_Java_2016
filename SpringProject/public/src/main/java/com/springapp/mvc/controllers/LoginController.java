package com.springapp.mvc.controllers;

import com.springapp.mvc.common.Users;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.services.UsersService;
import com.springapp.mvc.util.Methods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Controller
public class LoginController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CartService cartService;
    @Autowired
    private GoodsService goodsService;

    /*
     * Метод для проверки формы входа. То, что закомментировано - для SpringSecurity
     */
    @RequestMapping(value = "/login-ss-off", method = RequestMethod.POST)
    public String goOnProfile(ModelMap model) {
        String login = request.getParameter("j_username");
        String password = Methods.hashPass(request.getParameter("j_password"));
        String remember = request.getParameter("remember");
        List<Users> users = usersService.getAllUsers();
        for (Users u : users) {
            if (u.getUsername().equals(login)) {
                if (u.getPassword().equals(password)) {
                    if (u.getChecking()) {
                        request.getSession().setAttribute("user_id", u.getId());
                        request.getSession().setAttribute("login", u.getUsername());
                        request.getSession().setAttribute("fio", u.getName());
                        request.getSession().setAttribute("email", u.getEmail());
                        if (remember != null) {
                            Cookie cookie = new Cookie("mail", u.getEmail());
                            cookie.setMaxAge(24 * 60 * 60 * 30);
                            response.addCookie(cookie);
                        }
                        String sessionGoods = (String) request.getSession().getAttribute("goods");
                        if (sessionGoods != null) {
                            cartService.addAllGoodsFromSessionToCartOfUser(sessionGoods, (Long) request.getSession().getAttribute("user_id"));
                        } else {
                            request.setAttribute("cart", cartService.getCartsByUserID((Long) request.getSession().getAttribute("user_id")));
                        }
                        return "redirect:/profile";
                    }
                }
            }
        }
        model.put("error", "Неверное имя пользователя или пароль");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String forSpringSecurity(Boolean error) {
        error = Boolean.valueOf(request.getParameter("error"));
        String cart = request.getParameter("clear-cart");
        if (cart!=null) {
            request.setAttribute("clear-cart", "Ваша корзина пуста..");
        }
        if (error) {
            request.setAttribute("error", "Неверное имя пользователя или пароль");
        }
        String exep = request.getParameter("authoring");
        if (exep != null) {
            request.setAttribute("authoring", "Для офомления заказа необходимо зарегистрироваться или авторизоваться!");
        }
        return "login";
    }
}
