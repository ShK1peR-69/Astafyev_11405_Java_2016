package com.springapp.mvc.services;

import com.springapp.mvc.common.Order_Goods;
import com.springapp.mvc.repositories.Order_GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Service
public class Order_GoodsService {

    @Autowired
    private Order_GoodsRepository order_goodsRepository;

    @Transactional
    public List<Order_Goods> getAllOrder_Goods() {
        return order_goodsRepository.getAllOrder_Goods();
    }

    @Transactional
    public void addNewOrder_Goods(Order_Goods order_goods) {
        order_goodsRepository.addNewOrder_goods(order_goods);
    }
}
