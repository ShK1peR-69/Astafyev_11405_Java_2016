package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Cart;
import com.springapp.mvc.common.Goods;
import com.springapp.mvc.common.Users;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Repository
public class CartRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Добавление товара в корзину авторизованного пользовтеля
     */
    public void addGoodInCart(long good_id, long user_id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", user_id)).uniqueResult();
        Goods good = (Goods) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("id", good_id)).uniqueResult();
        Cart cart = (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("goods", good)).add(Restrictions.eq("users", user)).uniqueResult();

        if (cart != null) {
            cart.setCount(cart.getCount() + 1);
            sessionFactory.getCurrentSession().update(cart);
        } else {
            cart = new Cart(1, good, user);
            sessionFactory.getCurrentSession().save(cart);
        }
    }

    /*
     * Получение списка всех товаров в корзине для авторизованного пользователя
     */
    @SuppressWarnings("unchecked")
    public List<Cart> getCartsByUserID(Long id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", id)).uniqueResult();
        return sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).list();
    }

    /*
     * Отмена заказа -> очитстка корзины пользователя
     */
    @SuppressWarnings("unchecked")
    public void cancelOrder(Long id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", id)).uniqueResult();
        List<Cart> cart= sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).list();
        for(Cart c: cart){
            sessionFactory.getCurrentSession().delete(c);
        }
    }

    /*
     * Удаление товара из корзины авторизованного пользователя(если товаров несколько, удаляются все)
     */
    @SuppressWarnings("unchecked")
    public void deleteGoodFromCart(long good_id, long user_id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", user_id)).uniqueResult();
        Goods good = (Goods) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("id", good_id)).uniqueResult();
        Cart cart = (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).add(Restrictions.eq("goods", good)).uniqueResult();
        sessionFactory.getCurrentSession().delete(cart);
    }

    /*
     * Очистка корзины авторизованного пользователя после совершения заказа
     */
    @SuppressWarnings("unchecked")
    public void deleteCartAfterOrder(long user_id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", user_id)).uniqueResult();
        List<Cart> cart = sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).list();
        for (Cart c : cart) {
            sessionFactory.getCurrentSession().delete(c);
        }
    }

    /*
     *  Увеличение количества товара в корзине на 1 по ID товара для авторизованного пользователя
     */
    @SuppressWarnings("uncheked")
    public void addAgainOneGoodToCart(long good_id, long user_id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", user_id)).uniqueResult();
        Goods good = (Goods) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("id", good_id)).uniqueResult();
        Cart cart = (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).add(Restrictions.eq("goods", good)).uniqueResult();
        cart.setCount(cart.getCount() + 1);
        sessionFactory.getCurrentSession().update(cart);
    }

    /*
     *  Уменьшение количества товара в корзине на 1 по ID товара для авторизованного пользователя
     */
    @SuppressWarnings("uncheked")
    public void reduceOneGoodFromCart(long good_id, long user_id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", user_id)).uniqueResult();
        Goods good = (Goods) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("id", good_id)).uniqueResult();
        Cart cart = (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).add(Restrictions.eq("goods", good)).uniqueResult();
        if (cart.getCount() > 1) {
            cart.setCount(cart.getCount() - 1);
            sessionFactory.getCurrentSession().update(cart);
        }
    }

    /*
     *  Получение всех товаров в корзине для неавторизованного пользователя
     */
    @SuppressWarnings("unchecked")
    public List<Cart> getGoodsForAnonUser(String sessionGoods) {
        List<Cart> cartOfGoods = new LinkedList<>();
        if (sessionGoods == null || sessionGoods.equals("")) {
            return null;
        } else {
            String goods[] = sessionGoods.split("!");
            for (String g : goods) {
                String elem[] = g.split("_");
                Goods good = (Goods) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("id", Long.parseLong(elem[0]))).uniqueResult();
                Cart cart = new Cart(new Integer(elem[1]), good, null);
                cartOfGoods.add(cart);
            }
            return cartOfGoods;
        }
    }

    /*
     *  Перенос всех товаров из корзины неавторизованного пользователя при авторизации или регистрации
     */
    @SuppressWarnings("unchecked")
    public void addAllGoodsFromSessionToCartOfUser(String sessionGoods, long user_id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", user_id)).uniqueResult();
        if (sessionGoods != null && !sessionGoods.equals("")) {
            String goods[] = sessionGoods.split("!");
            for (String g : goods) {
                String elem[] = g.split("_");
                Goods good = (Goods) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("id", Long.parseLong(elem[0]))).uniqueResult();
                Cart cart = (Cart) sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("goods", good)).uniqueResult();
                if (cart != null) {
                    cart.setCount(cart.getCount() + new Integer(elem[1]));
                    sessionFactory.getCurrentSession().update(cart);
                } else {
                    cart = new Cart(new Integer(elem[1]), good, user);
                    sessionFactory.getCurrentSession().save(cart);
                }
            }
        }
    }
}