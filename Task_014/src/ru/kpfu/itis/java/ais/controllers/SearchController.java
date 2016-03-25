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
@RequestMapping("/search/*")
public class SearchController {

    @RequestMapping(method = RequestMethod.GET)
    public String addingPage(ModelMap model, HttpServletRequest request) {

        Pattern p = Pattern.compile("/search/aol");
        Matcher m = p.matcher(request.getRequestURI());
        Pattern p2 = Pattern.compile("/search/bing");
        Matcher m2 = p2.matcher(request.getRequestURI());
        Pattern p3 = Pattern.compile("/search/baidu");
        Matcher m3 = p3.matcher(request.getRequestURI());
        Pattern p4 = Pattern.compile("/search/yahoo");
        Matcher m4 = p4.matcher(request.getRequestURI());

        if (m.find()) {
            return "redirect:" + "http://search.aol.com/aol/search?";
        }
        if (m2.find()) {
            return "redirect:" + "http://www.bing.com/search?";
        }
        if (m3.find()) {
            return "redirect:" + "http://www.baidu.com/s?";
        }
        if (m4.find()) {
            return "redirect:" + "http://search.yahoo.com/search?";
        }
        return null;
    }
}
