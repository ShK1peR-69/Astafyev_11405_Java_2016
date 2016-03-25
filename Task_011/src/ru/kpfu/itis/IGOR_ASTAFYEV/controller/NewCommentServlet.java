package ru.kpfu.itis.IGOR_ASTAFYEV.controller;

import ru.kpfu.itis.IGOR_ASTAFYEV.repository.CommentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Astafyev Igor
 *         11-405
 */
@WebServlet(name = "NewCommentServlet", urlPatterns = "/addcomment")
public class NewCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getParameter("redic");
        String comment = request.getParameter("words");
        String author = (String) request.getSession().getAttribute("username");
        String page = request.getParameter("page");
        try {
            CommentRepository.addNewComment(author, comment, page);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
