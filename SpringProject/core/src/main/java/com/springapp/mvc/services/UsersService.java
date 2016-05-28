package com.springapp.mvc.services;

import com.springapp.mvc.common.Users;
import com.springapp.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Qualifier("users")
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

    @Transactional
    public void deleteUserFromDB(Long id) {
        userRepository.deleteUserFromDB(id);
    }

    @Transactional
    public void banForUser(Long id) {
        userRepository.banForUser(id);
    }

    @Transactional
    public void unblockUser(Long id) {
        userRepository.unblockUser(id);
    }
}