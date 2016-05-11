package com.springapp.mvc.aspects;

import com.springapp.mvc.security.MyUserDetail;
import com.springapp.mvc.services.OrderService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Aspect
@Component
public class ProfileAspect {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OrderService orderService;

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeSessionParameters)")
    public void includeParametersMethod() {
    }

    /*
     *  Создание сессии при переходе к своему профилю
     */
    @Before("includeParametersMethod()")
    public void includeParameters() {
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        request.getSession().setAttribute("fio", user.getUser().getName());
        request.getSession().setAttribute("login", user.getUser().getUsername());
        request.getSession().setAttribute("email", user.getUser().getEmail());
        request.getSession().setAttribute("allOrders", orderService.getAllOrdersByUserID(user.getUser().getId()));
    }
}