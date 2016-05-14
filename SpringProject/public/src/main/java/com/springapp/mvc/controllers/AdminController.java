package com.springapp.mvc.controllers;

import com.springapp.mvc.common.Goods;
import com.springapp.mvc.common.Users;
import com.springapp.mvc.services.CommentsService;
import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.services.OrderService;
import com.springapp.mvc.services.UsersService;
import com.springapp.mvc.util.Methods;
import com.springapp.mvc.util.SortingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

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
    @Autowired
    private GoodsService goodsService;

    private SortingFilter sortingFilter;

    /*
     *  Страничка админа со подробной информацией о каждом пользователе
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderAdminPage() throws IOException {
        if (request.getParameter("okay") != null) {
            request.setAttribute("okay", "Added good");
        }
        String users = "";
        int i = 1;
        List<Users> list = usersService.getAllUsers();
        for (Users u : list) {
            users = users + i + "). Имя: " + u.getName() + "\n" +
                    "Логин: " + u.getUsername() + "\n" + "Почта: " + u.getEmail() + "\n";
            i++;
        }
        Methods.generateNewFile(users);
        request.setAttribute("allUsers", usersService.getAllUsers());
        return "admin";
    }

    /*
     *  Полное удаление пользователя из БД
     */
    @RequestMapping(value = "/delete-user/{id}", method = RequestMethod.GET)
    public String deleteAllInformationAboutUser(@PathVariable Long id) {
        usersService.deleteUserFromDB(id);
        return "redirect:/admin";
    }

    /*
     *  Бан пользователю: изменяем ключ и меняем enable на false
     */
    @RequestMapping(value = "/block-user/{id}", method = RequestMethod.GET)
    public String blockingUser(@PathVariable Long id) {
        usersService.banForUser(id);
        return "redirect:/admin";
    }

    /*
     *  Удаление комментария пользователя
     */
    @RequestMapping(value = "/delete-user-comment/{id}", method = RequestMethod.GET)
    public String deleteCommentOfUser(@PathVariable long id) {
        commentsService.deleteUserCommentByAdmin(id);
        return "redirect:/admin";
    }

    /*
     *  Удаление заказа пользователя
     */
    @RequestMapping(value = "/delete-user-order/{id}", method = RequestMethod.GET)
    public String deleteOrderOfUser(@PathVariable long id) {
        orderService.deleteOrderByID(id);
        return "redirect:/admin";
    }


    /*
     *  Возвращение пользователя из бана: enable = true
     */
    @RequestMapping(value = "/unblocking-user/{id}", method = RequestMethod.GET)
    public String unblockingUser(@PathVariable Long id) {
        usersService.unblockUser(id);
        return "redirect:/admin";
    }

    /*
     *  Добавление нового товара в каталог
     */
    @RequestMapping(value = "/add-new-good", method = RequestMethod.POST)
    public String addingNewGoodToCatalog(ModelMap model) {
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        String price = request.getParameter("price");
        String size = request.getParameter("size");
        String sport = request.getParameter("sport");
        String brand = request.getParameter("brand");
        String category = request.getParameter("category");
        String describe = request.getParameter("describe");
        if (category.equals("man")) {
            category = "М";
        }
        if (category.equals("woman")) {
            category = "Ж";
        }
        if (category.equals("child")) {
            category = "Д";
        }
        if (category.equals("different")) {
            category = "Р";
        }
        if (sport.equals("football")) {
            sport = "Футбол";
        }
        if (sport.equals("hockey")) {
            sport = "Хоккей";
        }
        if (sport.equals("basketball")) {
            sport = "Баскетбол";
        }
        if (sport.equals("volleyball")) {
            sport = "Волейбол";
        }
        if (sport.equals("tennis")) {
            sport = "Теннис";
        }
        Goods good = new Goods(name, new BigDecimal(price), brand, 0, describe, size, image, sport, category);
        goodsService.addNewGood(good);
        model.put("okay", "okay");
        return "redirect:/admin";
    }

    /*
     *  Удаление товара из каталога
     */
    @RequestMapping(value = "/delete-good/{id}", method = RequestMethod.GET)
    public String deleteGoodFromCatalog(@PathVariable Long id) {
        goodsService.deleteGoodByID(id);
        return "redirect:/catalog";
    }


}
