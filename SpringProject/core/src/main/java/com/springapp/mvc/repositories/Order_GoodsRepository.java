package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Order_Goods;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Qualifier("order_goods")
@Repository
public class Order_GoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *  Список всех order_goods
     */
    @SuppressWarnings("unchecked")
    public List<Order_Goods> getAllOrder_Goods() {
        return sessionFactory.getCurrentSession().createCriteria(Order_Goods.class).list();
    }

    /*
     *  Добавление
     */
    @SuppressWarnings("unchecked")
    public void addNewOrder_goods(Order_Goods order_goods) {
        sessionFactory.getCurrentSession().save(order_goods);
    }
}
