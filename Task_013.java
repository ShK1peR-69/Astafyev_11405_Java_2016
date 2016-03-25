package ru.kpfu.itis.IGOR_ASTAFYEV;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_013
 */

@Aspect
public class Task_013 {

    @Around("execution(* *..*.setEmail(String..*))")
    public Object emailShouldBE(ProceedingJoinPoint jp) throws Throwable {
        String email = (String) jp.getArgs()[0];
        Pattern p = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        Matcher m = p.matcher(email);
        if (!m.find()) {
            throw new Exception("Be careful! It`s NOT an e-mail address!");
        }
        return jp.proceed();
    }
}