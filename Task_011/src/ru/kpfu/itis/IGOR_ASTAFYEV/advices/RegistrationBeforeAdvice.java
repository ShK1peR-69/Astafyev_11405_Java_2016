package ru.kpfu.itis.IGOR_ASTAFYEV.advices;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_011
 */

@Aspect
public class RegistrationBeforeAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o)
            throws Throwable {
        System.out.println("Now will be registrate new User..");
    }
}