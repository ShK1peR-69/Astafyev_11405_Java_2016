package com.springapp.mvc.security;

import com.springapp.mvc.common.Users;
import com.springapp.mvc.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UsersService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Users user = userService.getUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("User with name " + login + " not found!");
        }
        return new MyUserDetail(user);
    }
}