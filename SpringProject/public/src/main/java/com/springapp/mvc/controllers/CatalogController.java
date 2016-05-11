package com.springapp.mvc.controllers;

import com.springapp.mvc.common.Comments;
import com.springapp.mvc.common.Goods;
import com.springapp.mvc.common.Users;
import com.springapp.mvc.form.CommentFormBean;
import com.springapp.mvc.services.CommentsService;
import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.services.UsersService;
import com.springapp.mvc.util.SortingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Controller
public class CatalogController {

    final static String ATTR_COMMENT_FORM = "commentForm";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private CommentsService commentsService;

    private SortingFilter sortingFilter;


    /*
     * Отображение "карточки товара" - информации о конкретном товаре
     */
    @RequestMapping(value = "/goods/info/{id}", method = RequestMethod.GET)
    public String renderGoodInfo(@PathVariable("id") Long id) {
        request.setAttribute(ATTR_COMMENT_FORM, new CommentFormBean());
        request.setAttribute("tovar", goodsService.getGoodByID(id));
        request.setAttribute("comments", commentsService.getAllCommentsForGood(id));
        return "good-information";
    }

    /*
     * Проверка и лобавление нового отзыва/комментария о данном товаре
     */
    @RequestMapping(value = "/goods/info/{id}", method = RequestMethod.POST)
    public String addNewCommentForGood(@Valid @ModelAttribute(ATTR_COMMENT_FORM) CommentFormBean commentFormBean,
                                       BindingResult bindingResult, @PathVariable("id") Long id) {
//        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication();
        if (bindingResult.hasErrors()) {
            request.setAttribute("tovar", goodsService.getGoodByID(id));
            request.setAttribute("comments", commentsService.getAllCommentsForGood(id));
            return "good-information-error";
        }

        String login = (String) request.getSession().getAttribute("login");
        Users user = usersService.getUserByLogin(login);
        String message = request.getParameter("text-message");
        Goods good = goodsService.getGoodByID(id);
        Comments comment = new Comments(message, user, good);
        commentsService.addNewComment(comment);
        return "redirect:/goods/info/" + id;
    }

    /*
     * Список товаров определенного брэнда
     */
    @RequestMapping(value = "/catalog/brand/{name}", method = RequestMethod.GET)
    public String renderGoodsByBrand(@PathVariable("name") String name) {
        sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        request.setAttribute("filter", sortingFilter);
        request.setAttribute("allGoods", goodsService.getGoodsByBrand(name));
        return "catalog";
    }

    /*
     * Список товаров по возрасту и виду спорта
     */
    @RequestMapping(value = "/catalog/{age}/{sport}", method = RequestMethod.GET)
    public String renderGoodsBySportAndAge(@PathVariable("sport") String sport, @PathVariable("age") String age) {
        sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        request.setAttribute("filter", sortingFilter);
        request.setAttribute("allGoods", goodsService.getGoodsByAgeAndSport(sport, age));
        return "catalog";
    }

    /*
     * Список товаров по виду спорта
     */
    @RequestMapping(value = "/catalog/sport/{name}", method = RequestMethod.GET)
    public String renderGoodsBySport(@PathVariable("name") String name) {
        sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        request.setAttribute("filter", sortingFilter);
        request.setAttribute("allGoods", goodsService.getGoodsBySport(name));
        return "catalog";
    }

    /*
     * Список товаров по виду спорта
     */
    @RequestMapping(value = "/catalog/age/{name}", method = RequestMethod.GET)
    public String renderGoodsByAge(@PathVariable("name") String name) {
        sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        request.setAttribute("filter", sortingFilter);
        request.setAttribute("allGoods", goodsService.getGoodsByAge(name));
        return "catalog";
    }

    /*
     * Список самых дешевых товаров - "ВЫГОДНО"
     */
    @RequestMapping(value = "/catalog/goods/profitably", method = RequestMethod.GET)
    public String renderCheapestGoods() {
        sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        request.setAttribute("filter", sortingFilter);
        request.setAttribute("allGoods", goodsService.getCheapestGoods());
        return "catalog";
    }

    /*
     * Список самых популярных товаров - "ЛУЧШЕЕ"
     */
    @RequestMapping(value = "/catalog/goods/best-goods", method = RequestMethod.GET)
    public String renderTheBestGoods() {
        sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        request.setAttribute("filter", sortingFilter);
        request.setAttribute("allGoods", goodsService.getBestGoodsByPopular());
        return "catalog";
    }

    /*
     * Показать еще товары
     */
    @RequestMapping(value = "/catalog/show-more-goods", method = RequestMethod.POST)
    public String showMoreGoods(Integer page, Integer limit, Model model) {
        List<Goods> goods = goodsService.getAllGoods();
        int goods_count = goods.size();
        if (goods_count + limit > page * limit)
            model.addAttribute("goods", (goods_count > page * limit) ? goods : goods.subList(0, goods_count + limit - page * limit));
        return "catalog/ajaxGoods";
    }
}