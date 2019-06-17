package ru.kpfu.itis.java2k.ais;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class InfoBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objs, Object o)
            throws Throwable {
        System.out.println("Method '" + method.getName() + "'" + " is called.");
        Calendar now = Calendar.getInstance();
        int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);
        System.out.println("DAY: " + Calendar.SUNDAY);
    }

    public static void main(String[] args) {
        Developer dev = new Developer("Vasya");
        ProxyFactory pf = new ProxyFactory(dev);
        pf.addAdvice(new InfoBefore());
        Developer developer = (Developer) pf.getProxy();
        developer.getName();
        developer.work();
    }
}