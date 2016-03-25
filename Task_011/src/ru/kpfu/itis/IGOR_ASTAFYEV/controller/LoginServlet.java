package ru.kpfu.itis.IGOR_ASTAFYEV.controller;

import org.springframework.aop.framework.ProxyFactory;
import ru.kpfu.itis.IGOR_ASTAFYEV.advices.LoginAroundAdvice;
import ru.kpfu.itis.IGOR_ASTAFYEV.model.Users;
import ru.kpfu.itis.IGOR_ASTAFYEV.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashSet;


@WebServlet(name = "LoginServlet", urlPatterns = "/process")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String login = request.getParameter("username");

        if (login != null) {
            response.sendRedirect("/profile");
        } else {
            try {
                Cookie[] cook = request.getCookies();
                for (int i = 0; i < request.getCookies().length; i++) {
                    Cookie cookie = cook[i];
                    if (cookie.getName().equals("login")) {
                        request.setAttribute("login", cookie.getValue());
                        if (cookie.getName().equals("password")) {
                            response.sendRedirect("/profile");
                            return;
                        }
                    }
                }
                response.sendRedirect("/main");
            } catch (Exception ignored) {
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HashSet<Users> db = UserRepository.getAllUsers();
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String password = UserRepository.hashPass(request.getParameter("password"));

        for (Users u : db) {
            if (u.getLogin().equals(username)) {

                ProxyFactory pf = new ProxyFactory(u);
                LoginAroundAdvice lad = new LoginAroundAdvice();
                pf.addAdvice(lad);
                u = (Users) pf.getProxy();
                // Применяется around-совет

                if (u.getPass().equals(password)) {
                    session.setAttribute("mail", u.getMail());
                    session.setAttribute("sport", u.getSport());
                    session.setAttribute("age", u.getAge());
                    session.setAttribute("username", username);
                    Cookie cookie = new Cookie("login", username);
                    cookie.setMaxAge(24 * 60 * 60 * 30);
                    response.addCookie(cookie);
                    response.sendRedirect("/profile");
                    return;
                }
            }
        }
        response.sendRedirect("/mainEx");
    }
}
