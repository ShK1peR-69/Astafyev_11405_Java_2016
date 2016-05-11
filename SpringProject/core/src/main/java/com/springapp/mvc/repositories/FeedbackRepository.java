package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Feedback;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Repository
public class FeedbackRepository {


    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Сохранение нового отзыва в БД
     */
    public void addNewFeedback(Feedback feedback) {
        sessionFactory.getCurrentSession().save(feedback);
    }

}
