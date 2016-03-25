package ru.kpfu.itis.java.ais.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Astafyev Igor
 *         11-405
 *         for Task_015
 */

@Controller
@RequestMapping("/process")
public class ProcessController {

    @RequestMapping(method = RequestMethod.POST)
    public String processPage(ModelMap model, @RequestParam("menu") String value, @RequestParam("myText") String text) {

        if (value.equals("symbols")) {
            model.put("symbols", text.length());
        }

        if (value.equals("words")) {
            String myStr = text.replaceAll("( ){2,}", " ");
            String newString = myStr.trim();
            String[] words = newString.split(" ");
            model.put("words", words.length);
        }

        if (value.equals("sentences")) {
            String[] sents = text.split("\\.");
            model.put("sentences", sents.length);
        }

        if (value.equals("paragraphs")) {
            String myStr = text.trim();
            String[] pars = myStr.split("\n");
            model.put("paragraphs", pars.length);
        }
        return "result";
    }
}