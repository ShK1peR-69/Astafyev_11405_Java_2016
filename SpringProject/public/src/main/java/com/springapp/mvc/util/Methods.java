package com.springapp.mvc.util;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

public class Methods {

    /*
     * Добавление товара в корзину неавторизованного пользователя
     */
    public static String addBookInCartOfAnonUser(HttpServletRequest request, long id) {
        String goodsSession = (String) request.getSession().getAttribute("goods");
        if (goodsSession == null || goodsSession.equals("")) {
            goodsSession = id + "_1!";
        } else {
            boolean flag = false;
            String goodsMassiv[] = goodsSession.split("!");
            goodsSession = "";
            for (String g : goodsMassiv) {
                String elem[] = g.split("_");
                long good_id = Long.parseLong(elem[0]);
                if (good_id == id) {
                    int count = new Integer(elem[1]) + 1;
                    elem[1] = String.valueOf(count);
                    flag = true;
                }
                goodsSession = goodsSession + elem[0] + "_" + elem[1] + "!";
            }
            if (!flag) {
                goodsSession = goodsSession + id + "_1!";
            }
        }
        return goodsSession;
    }


    /*
     * Удаление товара из корзины неавторизованного пользователя(если их несколько, удаляются все)
     */
    public static String deleteGoodsFromCartOfAnonUser(HttpServletRequest request, long id) {
        String goods = (String) request.getSession().getAttribute("goods");
        String sessionGoods = "";
        if (goods != null) {
            String good[] = goods.split("!");
            for (String g : good) {
                String elem[] = g.split("_");
                if (Long.parseLong(elem[0]) != id) {
                    sessionGoods = sessionGoods + elem[0] + "_" + elem[1] + "!";
                }
            }
        }
        return sessionGoods;
    }

    /*
     *  Увеличение количества товара в корзине неавторизованного пользователя на 1 по ID товара
     */
    public static String addAgainOneGoodToCartOfAnonUser(HttpServletRequest request, Long id) {
        String sessionGoods = (String) request.getSession().getAttribute("goods");
        if (sessionGoods != null) {
            String goods[] = sessionGoods.split("!");
            sessionGoods = "";
            for (String g : goods) {
                String elem[] = g.split("_");
                if (Long.parseLong(elem[0]) == id) {
                    long count = Long.parseLong(elem[1]) + 1;
                    elem[1] = String.valueOf(count);
                }
                sessionGoods = sessionGoods + elem[0] + "_" + elem[1] + "!";
            }
        }
        return sessionGoods;
    }

    /*
     *  Уменьшение количества товара в корзине неавторизованного пользователя на 1 по ID товара
     */
    public static String reduceOneGoodFromCartOfAnonUser(HttpServletRequest request, Long id) {
        String sessionGoods = (String) request.getSession().getAttribute("goods");
        if (sessionGoods != null) {
            String goods[] = sessionGoods.split("!");
            sessionGoods = "";
            for (String g : goods) {
                String elem[] = g.split("_");
                if (Long.parseLong(elem[0]) == id) {
                    if (Long.parseLong(elem[1]) > 1) {
                        long count = Long.parseLong(elem[1]) - 1;
                        elem[1] = String.valueOf(count);
                    }
                }
                sessionGoods = sessionGoods + elem[0] + "_" + elem[1] + "!";
            }
        }
        return sessionGoods;
    }

    public static void generateNewFile(String text) throws IOException {
        File file = new File("users.pdf");
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
    }
}