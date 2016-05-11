package com.springapp.mvc.services;

import com.springapp.mvc.common.Cart;
import com.springapp.mvc.repositories.CartRepository;
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
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public void addGoodInCart(long good_id, long user_id) {
        cartRepository.addGoodInCart(good_id, user_id);
    }

    @Transactional
    public List<Cart> getCartsByUserID(long user_id) {
        return cartRepository.getCartsByUserID(user_id);
    }

    @Transactional
    public void deleteGoodFromCart(long good_id, long user_id) {
        cartRepository.deleteGoodFromCart(good_id, user_id);
    }

    @Transactional
    public void deleteCartAfterOrder(long user_id) {
        cartRepository.deleteCartAfterOrder(user_id);
    }

    @Transactional
    public void addAgainOneGoodToCart(long good_id, long user_id) {
        cartRepository.addAgainOneGoodToCart(good_id, user_id);
    }

    @Transactional
    public void reduceOneGoodFromCart(long good_id, long user_id) {
        cartRepository.reduceOneGoodFromCart(good_id, user_id);
    }

    @Transactional
    public List<Cart> getGoodsForAnonUser(String allGoods) {
        return cartRepository.getGoodsForAnonUser(allGoods);
    }

    @Transactional
    public void addAllGoodsFromSessionToCartOfUser(String sessionGoods, long user_id) {
        cartRepository.addAllGoodsFromSessionToCartOfUser(sessionGoods, user_id);
    }

    @Transactional
    public void cancelOrder(long id) {
        cartRepository.cancelOrder(id);
    }
}