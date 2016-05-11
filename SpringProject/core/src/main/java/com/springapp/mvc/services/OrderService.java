package com.springapp.mvc.services;

import com.springapp.mvc.common.Order;
import com.springapp.mvc.repositories.OrderRepository;
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
public class OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void addNewOrder(Order order) {
        orderRepository.addNewOrder(order);
    }

    @Transactional
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Transactional
    public List<Order> getAllOrdersByUserID(Long id) {
        return orderRepository.getAllOrdersByUserID(id);
    }

    @Transactional
    public void deleteOrderByID(long id) {
        orderRepository.deleteOrderByID(id);
    }
}
