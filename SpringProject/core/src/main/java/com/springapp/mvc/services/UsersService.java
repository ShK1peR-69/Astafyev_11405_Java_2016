package com.springapp.mvc.services;

import com.springapp.mvc.common.Users;
import com.springapp.mvc.repositories.UserRepository;
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
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public List<Users> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Transactional
    public void addNewUser(Users user) {
        userRepository.addNewUser(user);
    }

    @Transactional
    public Users getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Transactional
    public void changeCheckingAfterSendingMail(String login) {
        userRepository.changeCheckingAfterSendingMail(login);
    }
}