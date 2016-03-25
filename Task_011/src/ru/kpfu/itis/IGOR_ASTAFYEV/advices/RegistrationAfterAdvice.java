package ru.kpfu.itis.IGOR_ASTAFYEV.advices;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.AfterReturningAdvice;
import ru.kpfu.itis.IGOR_ASTAFYEV.controller.RegistrationServlet;

import java.lang.reflect.Method;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_011
 */

@Aspect
public class RegistrationAfterAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1)
            throws Throwable {
        System.out.println("New user " + RegistrationServlet.newUser + " was successful registrated!");
    }
}