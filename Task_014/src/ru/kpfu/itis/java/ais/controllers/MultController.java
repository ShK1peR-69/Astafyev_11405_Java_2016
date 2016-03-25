package ru.kpfu.itis.java.ais.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_014
 */

@Controller
@RequestMapping("/mult/*/*")
public class MultController {

    @RequestMapping(method = RequestMethod.GET)
    public String multingPage(ModelMap model, HttpServletRequest request) {

        Pattern p = Pattern.compile(".*/add/([0-9]+)/([0-9]+)");
        Matcher m = p.matcher(request.getRequestURI());
        if (m.find()) {
            int a = new Integer(m.group(1));
            int b = new Integer(m.group(2));
            int mult = a * b;
            model.put("multing", mult);
        }
        return "mult";
    }
}
