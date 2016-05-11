package com.springapp.mvc.services;

import com.springapp.mvc.common.Comments;
import com.springapp.mvc.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Transactional
    public void addNewComment(Comments comment) {
        commentsRepository.addNewComment(comment);
    }

    @Transactional
    public void deleteCommentByID(Long id) {
        commentsRepository.deleteCommentByID(id);
    }

    @Transactional
    public List<Comments> getAllCommentsForGood(long good_id) {
        return commentsRepository.getAllCommentsForGood(good_id);
    }

    @Transactional
    public void deleteUserCommentByAdmin(Long id) {
        commentsRepository.deleteUserCommentByAdmin(id);
    }
}
