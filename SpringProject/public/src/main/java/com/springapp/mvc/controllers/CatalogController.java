package com.springapp.mvc.controllers;

import com.springapp.mvc.common.Category;
import com.springapp.mvc.common.Goods;
import com.springapp.mvc.services.CategoryService;
import com.springapp.mvc.services.GoodsService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Controller
public class CatalogController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GoodsService goodsService;

    /*
     * Получение списка товаров конкретной категории
     */
    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET)
    public String sortingByIDgroup(@PathVariable long id) throws JSONException, IOException {
        Category category = categoryService.getCategoryByID(id);
        List<Goods> goods = goodsService.getGoodsByColorID(category);
        if (goods.isEmpty()) {
            request.setAttribute("allGoods", null);
        } else {
            request.setAttribute("allGoods", goods);
        }
        return "catalog";
    }

    /*
     * Отображение "карточки товара" - информации о конкретном товаре
     */
    @RequestMapping(value = "goods/info/{id}", method = RequestMethod.GET)
    public String renderGoodInfo(@PathVariable("id") Long id) {
        request.setAttribute("tovar", goodsService.getGoodByID(id));
        return "good-information";
    }

    /*
     * Список товаров определенного брэнда
     */
    @RequestMapping(value = "/catalog/brand/{name}", method = RequestMethod.GET)
    public String renderGoodsByBrand(@PathVariable("name") String name) {
        request.setAttribute("allGoods", goodsService.getGoodsByBrand(name));
        return "catalog";
    }

    /*
     * Список товаров по возрасту и виду спорта
     */
    @RequestMapping(value = "/catalog/{age}/{sport}", method = RequestMethod.GET)
    public String renderGoodsBySportAndAge(@PathVariable("sport") String sport, @PathVariable("age") String age) {
        request.setAttribute("allGoods", goodsService.getGoodsByAgeAndSport(sport, age));
        return "catalog";
    }

    /*
     * Список товаров по виду спорта
     */
    @RequestMapping(value = "/catalog/sport/{name}", method = RequestMethod.GET)
    public String renderGoodsBySport(@PathVariable("name") String name) {
        request.setAttribute("allGoods", goodsService.getGoodsBySport(name));
        return "catalog";
    }

    /*
     * Список товаров по виду спорта
     */
    @RequestMapping(value = "/catalog/age/{name}", method = RequestMethod.GET)
    public String renderGoodsByAge(@PathVariable("name") String name) {
        request.setAttribute("allGoods", goodsService.getGoodsByAge(name));
        return "catalog";
    }
}