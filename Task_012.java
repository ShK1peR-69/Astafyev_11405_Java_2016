package ru.kpfu.itis.IGOR_ASTAFYEV;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_012
 */

@Aspect
public class Task_012 {

    @Around("execution(* *..*.execute(..))")
    public Object searchingSQLInjections(ProceedingJoinPoint jp) throws Throwable {
        String str = (String) jp.getArgs()[0];
        String injection = str.toLowerCase();
        Pattern p = Pattern.compile(".*(select|insert|update|delete|create|describe|alert|show|drop).*");
        Matcher m = p.matcher(injection);
        if (!m.find()) {
            throw new Exception("Error! Danger! Request has some injection.");
        }
        return jp.proceed();
    }
}