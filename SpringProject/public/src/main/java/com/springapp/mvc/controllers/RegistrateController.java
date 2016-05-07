package com.springapp.mvc.controllers;

import com.springapp.mvc.common.Users;
import com.springapp.mvc.form.RegistrationFormBean;
import com.springapp.mvc.util.Methods;
import com.springapp.mvc.services.CartService;
import com.springapp.mvc.services.OrderService;
import com.springapp.mvc.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.itis.java.ais.Mailing;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Controller
@RequestMapping(value = "/registration")
public class RegistrateController{

    final static String ATTR_REGISTRATION_FORM = "regForm";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CartService cartService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private OrderService orderService;

    /*
     * Возвращает форму для регистрации нового пользователя
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistrationPage() {
        request.setAttribute(ATTR_REGISTRATION_FORM, new RegistrationFormBean());
        return "registration";
    }

    /*
     * Регистрация нового пользователя, добавление его в БД
     */
    @RequestMapping(method = RequestMethod.POST)
    public String registrationForm(
            @Valid @ModelAttribute(ATTR_REGISTRATION_FORM) RegistrationFormBean registrationFormBean,
            BindingResult bindingResult, ModelMap model) throws MessagingException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        String name = request.getParameter("fio");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String pass_one = Methods.hashPass(request.getParameter("password_one"));
        String pass_two = Methods.hashPass(request.getParameter("password_two"));
        String key = "TEA(_)zaqwsxcde" + email.charAt(1) + "123rfvbgtyhn456" + login + "mjuik789_0987654321)(SHOP";
        if (!pass_one.equals(pass_two)) {
            model.put("message_password", "Пароли не совпадают");
            return "registration";
        }
        Users user = new Users(name, login, email, pass_one, false, key, "ROLE_USER");
        List<Users> allUsers = usersService.getAllUsers();
        for (Users u : allUsers) {
            if (u.getEmail().equals(email)) {
                model.put("message_email", "Извините, но пользователь с таким e-mail уже зарегистрирован");
                return "registration";
            }
            if (u.getUsername().equals(login)) {
                model.put("message_login", "Извините, но пользователь с таким Логином уже зарегистрирован");
                return "registration";
            }
        }
        usersService.addNewUser(user);
        String sessionGoods = (String) request.getSession().getAttribute("goods");
        if (sessionGoods != null) {
            cartService.addAllGoodsFromSessionToCartOfUser(sessionGoods, user.getId());
        } else {
            request.setAttribute("cart", cartService.getCartsByUserID(user.getId()));
        }
        Mailing.sendApprovalMail(name, login, email, key);
        return "redirect:/";
    }

    /*
     * Подтверждение регистрации пользовтеля после получение e-mail
     */
    @RequestMapping(value = "/approval/{login}/{key}", method = RequestMethod.GET)
    public String verificationMethod(@PathVariable("login") String login) {
        usersService.changeCheckingAfterSendingMail(login);
        Users user = usersService.getUserByLogin(login);
        request.getSession().setAttribute("fio", user.getName());
        request.getSession().setAttribute("login", login);
        request.getSession().setAttribute("email", user.getEmail());
        request.getSession().setAttribute("cart", cartService.getCartsByUserID(user.getId()));
        request.getSession().setAttribute("allOrders", orderService.getAllOrdersByUserID(user.getId()));
        return "redirect:/profile";
    }
}