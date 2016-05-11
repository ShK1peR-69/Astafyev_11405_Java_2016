package com.springapp.mvc.repositories;

import com.springapp.mvc.common.*;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *  Список всех пользователей из БД, кроме админов
     */
    @SuppressWarnings("unchecked")
    public List<Users> getAllUsers() {
        List<Users> users = sessionFactory.getCurrentSession().createCriteria(Users.class).list();
        Iterator iterator = users.iterator();
        while (iterator.hasNext()) {
            Users u = (Users) iterator.next();
            if (u.getRole().equals("ROLE_ADMIN")) {
                iterator.remove();
            }
        }
        return users;
    }

    /*
     *  Добавление нового пользователя
     */
    public void addNewUser(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    /*
     *  Получение пользовтеля из БД по Логину
     */
    public Users getUserByLogin(String username) {
        return (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("username", username)).uniqueResult();
    }

    /*
     *  Изменение состояния пользовтеля после подтверждения регистрации
     */
    public void changeCheckingAfterSendingMail(String username) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("username", username)).uniqueResult();
        user.setChecking(true);
        sessionFactory.getCurrentSession().update(user);
    }

    /*
     *  Удаление пользователя и всей его информации из БД
     */
    @SuppressWarnings("unchecked")
    public void deleteUserFromDB(Long id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", id)).uniqueResult();
        List<Cart> cart = sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).list();
        for (Cart c : cart) {
            sessionFactory.getCurrentSession().delete(c);
        }
        List<Order> order = sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).list();
        for (Order o : order) {
            sessionFactory.getCurrentSession().delete(o);
        }
        List<Address> address = sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).list();
        for (Address a : address) {
            sessionFactory.getCurrentSession().delete(a);
        }
        List<Comments> comments = sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("users", user)).list();
        for (Comments comment : comments) {
            sessionFactory.getCurrentSession().delete(comment);
        }
        sessionFactory.getCurrentSession().delete(user);
    }

    /*
     *  Блокировка(бан) пользователя
     */
    public void banForUser(Long id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", id)).uniqueResult();
        user.setKey("$$///thisUserIsBanned/&77$%ForAllTime##@%0^!");
        user.setChecking(false);
        sessionFactory.getCurrentSession().update(user);
    }

    /*
     *  Разбан пользователя
     */
    public void unblockUser(Long id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", id)).uniqueResult();
        user.setChecking(true);
        sessionFactory.getCurrentSession().update(user);
    }
}
