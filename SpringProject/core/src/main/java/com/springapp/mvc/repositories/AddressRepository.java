package com.springapp.mvc.repositories;

import com.springapp.mvc.common.Address;
import com.springapp.mvc.common.Users;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Qualifier("address")
@Repository
public class AddressRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /*
     * Сохранение нового адреса в БД
     */
    public void addNewAddress(Address address) {
        sessionFactory.getCurrentSession().save(address);
    }

    /*
     * Получение адреса для пользователя с заданным ID
     */
    @SuppressWarnings("unchecked")
    public Address getAddressByUser(Long id) {
        Users user = (Users) sessionFactory.getCurrentSession().createCriteria(Users.class).add(Restrictions.eq("id", id)).uniqueResult();
        return (Address) sessionFactory.getCurrentSession().createCriteria(Address.class).add(Restrictions.eq("users", user)).uniqueResult();
    }

}