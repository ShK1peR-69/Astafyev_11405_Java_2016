package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Order;
import com.springapp.mvc.common.Order_Goods;
import com.springapp.mvc.common.Users;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Repository
public class OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *  Все заказы из БД
     */
    @SuppressWarnings("unchecked")
    public List<Order> getAllOrders() {
        return sessionFactory.getCurrentSession().createCriteria(Order.class).list();
    }

    /*
     *  Добавление нового заказа
     */
    public void addNewOrder(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    /*
     *  Все заказы определенного пользователя с заданным ID
     */
    @SuppressWarnings("unchecked")
    public List<Order> getAllOrdersByUserID(Long id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", id)).uniqueResult();
        return sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.eq("users", user)).list();
    }

    /*
     *  Удаление заказа по заданному ID
     */
    @SuppressWarnings("unchecked")
    public void deleteOrderByID(long id) {
        Order order = (Order) sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.eq("id", id)).uniqueResult();
        List<Order_Goods> order_gooods = sessionFactory.getCurrentSession().createCriteria(Order_Goods.class).add(Restrictions.eq("order_id", order)).list();
        for (Order_Goods og : order_gooods) {
            og.getGoods().setPopular(og.getGoods().getPopular() - 1);
            sessionFactory.getCurrentSession().delete(og);
        }
        sessionFactory.getCurrentSession().delete(order);
    }
}
