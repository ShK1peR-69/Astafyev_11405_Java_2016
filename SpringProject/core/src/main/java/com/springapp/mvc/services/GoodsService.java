package com.springapp.mvc.services;

import com.springapp.mvc.common.Category;
import com.springapp.mvc.common.Goods;
import com.springapp.mvc.repositories.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Transactional
    public List<Goods> getAllGoods() {
        return goodsRepository.getAllGoods();
    }

    @Transactional
    public List<Goods> getGoodsByColorID(Category category) {
        return goodsRepository.getGoodsByColorID(category);
    }

    @Transactional
    public List<Goods> getGoodsByName(String name) {
        return goodsRepository.getGoodsByName(name);
    }

    @Transactional
    public Goods getGoodByID(long id) {
        return goodsRepository.getGoodById(id);
    }

    @Transactional
    public List<Goods> getGoodsByBrand(String brand) {
        return goodsRepository.getGoodsByBrand(brand);
    }

    @Transactional
    public List<Goods> getGoodsBySport(String sport) {
        return goodsRepository.getGoodsBySport(sport);
    }

    @Transactional
    public List<Goods> getGoodsByAge(String age) {
        return goodsRepository.getGoodsByAge(age);
    }

    @Transactional
    public List<Goods> getGoodsByAgeAndSport(String sport, String age) {
        return goodsRepository.getGoodsByAgeAndSport(sport, age);
    }
}
