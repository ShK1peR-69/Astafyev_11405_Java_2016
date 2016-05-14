package com.springapp.mvc.aspects;

import com.springapp.mvc.controllers.ProfileController;
import com.springapp.mvc.security.MyUserDetail;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.logging.Logger;

/**
 * @author Astafyev Igor
 *         11-405
 */
public class BeforeLogsAspect {

    @Pointcut("@annotation(com.springapp.mvc.aspects.annotation.IncludeBeforeLogs)")
    public void includeLogsMethod() {
    }

    /*
     *  Логирование перед методом
     */
    @Before("includeLogsMethod()")
    public void includeLogs() {
        Date date = new Date();
        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Logger log = Logger.getLogger(ProfileController.class.getName());
        log.info(date + ": " + "User with this ID=" + user.getUser().getId() + " entered his profile");
    }
}
