package com.springapp.mvc.controllers;

import com.springapp.mvc.common.Goods;
import com.springapp.mvc.services.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Controller
public class MainPageController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodsService goodsService;

    /*
     * Главная страница с каталогом товаров
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String renderMainPage() {
        request.setAttribute("allGoods", goodsService.getAllGoods());
        return "mainpage";
    }

    /*
     * Собственно каталог товаров
     */
    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String renderCatalogPage() {
        request.setAttribute("allGoods", goodsService.getAllGoods());
        return "catalog";
    }

    /*
     * Поиск товара по названию или части названия
     */
    @RequestMapping(value = "/catalog/search", method = RequestMethod.GET)
    public String searchingPage() {
        String word = request.getParameter("word");
        List<Goods> goods = goodsService.getGoodsByName(word);
        if(goods.isEmpty()){
            request.setAttribute("allGoods", null);
            return "catalog";
        }
        request.setAttribute("allGoods", goods);
        return "catalog";
    }
}