package ru.kpfu.itis.java.ais.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Controller
@RequestMapping("/getdate")
public class DateController {

    @RequestMapping(method = RequestMethod.GET)
    public String datePage(ModelMap model) {
        model.put("date", new java.util.Date());
        return "date";
    }
}