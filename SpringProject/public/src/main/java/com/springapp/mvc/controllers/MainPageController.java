package com.springapp.mvc.controllers;

import com.springapp.mvc.common.Goods;
import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.util.SortingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Controller
public class MainPageController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodsService goodsService;

    private SortingFilter sortingFilter;

    @RequestMapping(value = "/catalog/sort", method = RequestMethod.POST)
    public String sortingMethod(@RequestParam(required = false) String sport, @RequestParam(required = false) String sorting,
                                @RequestParam(required = false) String from, @RequestParam(required = false) String to)
            throws NumberFormatException {
        BigDecimal[] price = {BigDecimal.valueOf(0), BigDecimal.valueOf(1000000)};
        try {
            if (!from.isEmpty()) {
                price[0] = BigDecimal.valueOf(Long.parseLong(from));
                sortingFilter.setFrom(BigDecimal.valueOf(Long.parseLong(from)));
            }
            if (!to.isEmpty()) {
                price[1] = BigDecimal.valueOf(Long.parseLong(to));
                sortingFilter.setTo(BigDecimal.valueOf(Long.parseLong(to)));
            }
            sortingFilter.setSport(sport);
            sortingFilter.setSorting(sorting);
            request.setAttribute("filter", sortingFilter);
        } catch (NumberFormatException ex) {
            request.setAttribute("filter", new SortingFilter(sport, sorting, BigDecimal.valueOf(0), BigDecimal.valueOf(0)));
        }
        ArrayList<Goods> goods;
        if (sport != null) {
            goods = (ArrayList<Goods>) goodsService.getSortingGoodsByPrice(sorting);
        } else {
            goods = (ArrayList<Goods>) goodsService.getAllGoods();
        }
        goods = goodsService.getSortingGoodsBySport(sport, goods);
        goods = goodsService.getSortingGoodsByPriceFromTo(price[0], price[1], goods);
        request.setAttribute("allGoods", goods);
        return "catalog";
    }


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
        if (request.getParameter("goodses") != null) {
            request.setAttribute("allGoods", null);
            sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
            request.setAttribute("filter", sortingFilter);
            return "catalog";
        }
        sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        request.setAttribute("filter", sortingFilter);
        request.setAttribute("allGoods", goodsService.getAllGoods());
        return "catalog";
    }

    /*
     * Поиск товара по названию или части названия
     */
    @RequestMapping(value = "/catalog/search", method = RequestMethod.GET)
    public String searchingPage(ModelMap model) {
        String word = request.getParameter("word");
        List<Goods> goods = goodsService.getGoodsByName(word);
        if (goods.size() == 0) {
            model.put("goodses", "error");
            return "redirect:/catalog";
        }
        sortingFilter = new SortingFilter("football", "asc", BigDecimal.valueOf(0), BigDecimal.valueOf(0));
        request.setAttribute("filter", sortingFilter);
        request.setAttribute("allGoods", goods);
        return "catalog";
    }
}