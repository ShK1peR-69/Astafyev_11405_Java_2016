package ru.kpfu.itis.IGOR_ASTAFYEV.advices;

import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_011
 */

public class LoginAroundAdvice implements org.aopalliance.intercept.MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object o;
        System.out.println("Some user want to enter the site..");
        o = methodInvocation.proceed();
        System.out.println("User was successful entered!");
        return o;
    }
}