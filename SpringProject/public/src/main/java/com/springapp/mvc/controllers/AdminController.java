package com.springapp.mvc.controllers;

import com.springapp.mvc.services.CommentsService;
import com.springapp.mvc.services.OrderService;
import com.springapp.mvc.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private OrderService orderService;

    /*
     *  Страничка админа со подробной информацией о каждом пользователе
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderAdminPage() throws IOException {
        request.setAttribute("allUsers", usersService.getAllUsers());
        return "admin";
    }

    /*
     *  Полное удаление пользователя из БД
     */
    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.GET)
    public String deleteAllInformationAboutUser(@PathVariable Long id) {
        usersService.deleteUserFromDB(id);
        request.setAttribute("allUsers", usersService.getAllUsers());
        return "redirect:/admin";
    }

    /*
     *  Бан пользователю: изменяем ключ и меняем enable на false
     */
    @RequestMapping(value = "/block-user/{id}", method = RequestMethod.GET)
    public String blockingUser(@PathVariable Long id) {
        usersService.banForUser(id);
        request.setAttribute("allUsers", usersService.getAllUsers());
        return "redirect:/admin";
    }

    /*
     *  Удаление комментария пользователя
     */
    @RequestMapping(value = "/delete-user-comment/{id}", method = RequestMethod.GET)
    public String deleteCommentOfUser(@PathVariable Long id) {
        commentsService.deleteUserCommentByAdmin(id);
        request.setAttribute("allUsers", usersService.getAllUsers());
        return "redirect:/admin";
    }

    /*
     *  Удаление заказа пользователя
     */
    @RequestMapping(value = "/delete-user-order/{id}", method = RequestMethod.GET)
    public String deleteOrderOfUser(@PathVariable Long id) {
        orderService.deleteOrderByID(id);
        request.setAttribute("allUsers", usersService.getAllUsers());
        return "redirect:/admin";
    }


    /*
     *  Возвращение пользователя из бана: enable = true
     */
    @RequestMapping(value = "/unblocking-user/{id}", method = RequestMethod.GET)
    public String unblockingUser(@PathVariable Long id) {
        usersService.unblockUser(id);
        request.setAttribute("allUsers", usersService.getAllUsers());
        return "redirect:/admin";
    }
}
