package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Comments;
import com.springapp.mvc.common.Goods;
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
public class CommentsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Сохранение нового комментария в БД
     */
    public void addNewComment(Comments comments) {
        sessionFactory.getCurrentSession().save(comments);
    }

    /*
     *  Удаление комментария по ID
     */
    @SuppressWarnings("unchecked")
    public void deleteCommentByID(Long id) {
        Comments comment = (Comments) sessionFactory.getCurrentSession().createCriteria(Comments.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessionFactory.getCurrentSession().delete(comment);
    }

    /*
     * Список всех комментариев для товара с заданным ID
     */
    @SuppressWarnings("unchecked")
    public List<Comments> getAllCommentsForGood(long good_id) {
        Goods good = (Goods) sessionFactory.getCurrentSession().createCriteria(Goods.class).add(Restrictions.eq("id", good_id)).uniqueResult();
        return sessionFactory.getCurrentSession().createCriteria(Comments.class).add(Restrictions.eq("goods", good)).list();
    }

    /*
     *  Удаление комментария пользователя
     */
    @SuppressWarnings("unchecked")
    public void deleteUserCommentByAdmin(Long id) {
        Comments comment = (Comments) sessionFactory.getCurrentSession().createCriteria(Comments.class).add(Restrictions.eq("id", id)).uniqueResult();
        sessionFactory.getCurrentSession().delete(comment);
    }
}
