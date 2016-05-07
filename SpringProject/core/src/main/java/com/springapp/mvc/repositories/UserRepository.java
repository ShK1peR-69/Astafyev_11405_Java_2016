package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Users;
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
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     *  Список всех пользователей из БД
     */
    @SuppressWarnings("unchecked")
    public List<Users> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(Users.class).list();
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
}
