package com.springapp.mvc.controllers;

import com.springapp.mvc.aspects.annotation.IncludeSessionParameters;
import com.springapp.mvc.common.Feedback;
import com.springapp.mvc.form.FeedbackFormBean;
import com.springapp.mvc.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author Astafyev Igor
 *         11-405
 */

@Controller
@RequestMapping(value = "/feedback")
public class FeedbackController {

    final static String ATTR_FEEDBACK_FORM = "fbkForm";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FeedbackService feedbackService;

    /*
     * Генерация формы для нового отзыва
     */
    @RequestMapping(method = RequestMethod.GET)
    public String renderFeedBackPage() {
        request.setAttribute(ATTR_FEEDBACK_FORM, new FeedbackFormBean());
        return "feedback";
    }


    /*
     * Добавление нового отзыва в БД
     */
    @IncludeSessionParameters
    @RequestMapping(method = RequestMethod.POST)
    public String addAddressForm(
            @Valid @ModelAttribute(ATTR_FEEDBACK_FORM) FeedbackFormBean feedbackFormBean,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "feedback";
        }

        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        Feedback feedback = new Feedback(login, email, subject,message);
        feedbackService.addNewFeedback(feedback);
        request.setAttribute("add","flag");
        return "feedback";
    }

}
