package com.springapp.mvc.controllers;

import com.springapp.mvc.services.CommentsService;
import com.springapp.mvc.services.GoodsService;
import com.springapp.mvc.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Astafyev Igor
 *         11-405
 *         for SemWork
 */

@Controller
public class CommentsController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private UsersService usersService;


    @RequestMapping(value = "/delete-comment/{good_id}/{comment_id}", method = RequestMethod.GET)
    public String deleteCommentForGood(@PathVariable long good_id, @PathVariable long comment_id) {
//        MyUserDetail user = (MyUserDetail) SecurityContextHolder.getContext().getAuthentication();
        commentsService.deleteCommentByID(comment_id);
        return "redirect:/goods/info/" + good_id;
    }

}
