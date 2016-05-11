package com.springapp.mvc.services;

import com.springapp.mvc.common.Feedback;
import com.springapp.mvc.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Transactional
    public void addNewFeedback(Feedback feedback) {
        feedbackRepository.addNewFeedback(feedback);
    }
}
