package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Category;
import com.springapp.mvc.common.Goods;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Repository
public class GoodsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *  Получение списка всх товаров из БД
     */
    @SuppressWarnings("unchecked")
    public List<Goods> getAllGoods() {
        return sessionFactory.getCurrentSession().createCriteria(Goods.class).list();
    }

    /*
     *  Получение списка всх товаров определенного цвета из БД
     */
    @SuppressWarnings("unchecked")
    public List<Goods> getGoodsByColorID(Category category) {
        return (List<Goods>) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("category", category)).list();
    }

    /*
     *  Получение списка товаров по названию или части названия
     */
    @SuppressWarnings("unchecked")
    public List<Goods> getGoodsByName(String name) {
        return (List<Goods>) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.like("name", "%" + name + "%")).list();
    }

    /*
     *  Получение товара по его ID
     */
    public Goods getGoodById(Long id) {
        return (Goods) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    /*
     *  Получение списка товаров по названию брэнда
     */
    @SuppressWarnings("unchecked")
    public List<Goods> getGoodsByBrand(String brand) {
        if (brand.equals("puma")) {
            brand = "Puma";
        }
        if (brand.equals("nike")) {
            brand = "Nike";
        }
        if (brand.equals("adidas")) {
            brand = "Adidas";
        }
        if (brand.equals("joma")) {
            brand = "Joma";
        }
        if (brand.equals("umbro")) {
            brand = "Umbro";
        }
        return (List<Goods>) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("brand", brand)).list();
    }

    /*
     *  Получение списка товаров по виду спорта
     */
    @SuppressWarnings("unchecked")
    public List<Goods> getGoodsBySport(String sport) {
        if (sport.equals("football")) {
            sport = "Футбол";
        }
        if (sport.equals("basketball")) {
            sport = "Баскетбол";
        }
        if (sport.equals("volleyball")) {
            sport = "Волейбол";
        }
        if (sport.equals("hockey")) {
            sport = "Хоккей";
        }
        if (sport.equals("tennnis")) {
            sport = "Теннис";
        }
        return (List<Goods>) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("sport", sport)).list();
    }

    /*
     *  Получение списка товаров по половому признаку
     */
    @SuppressWarnings("unchecked")
    public List<Goods> getGoodsByAge(String age) {
        if (age.equals("men")) {
            age = "М";
        }
        if (age.equals("women")) {
            age = "Ж";
        }
        if (age.equals("child")) {
            age = "Д";
        }
        if (age.equals("different")) {
            age = "Р";
        }
        return (List<Goods>) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("age", age)).list();
    }

    /*
     *  Получение списка товаров по спорту и половому признаку
     */
    @SuppressWarnings("unchecked")
    public List<Goods> getGoodsByAgeAndSport(String sport, String age) {
        if (sport.equals("football")) {
            sport = "Футбол";
        }
        if (sport.equals("basketball")) {
            sport = "Баскетбол";
        }
        if (sport.equals("volleyball")) {
            sport = "Волейбол";
        }
        if (sport.equals("hockey")) {
            sport = "Хоккей";
        }
        if (sport.equals("tennnis")) {
            sport = "Теннис";
        }
        if (age.equals("men")) {
            age = "М";
        }
        if (age.equals("women")) {
            age = "Ж";
        }
        if (age.equals("child")) {
            age = "Д";
        }
        if (age.equals("different")) {
            age = "Р";
        }
        return (List<Goods>) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("age", age)).add(Restrictions.eq("sport", sport)).list();
    }
}