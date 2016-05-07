package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Category;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Qualifier("category")
@Repository
public class CategoryRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *  Получение конкретной категории по ID
     */
    public Category getCategoryByID(long id) {
        return (Category) sessionFactory.getCurrentSession().createCriteria(Category.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
}