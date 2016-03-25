package ru.kpfu.itis.IGOR_ASTAFYEV.controller;

import org.springframework.aop.framework.ProxyFactory;
import ru.kpfu.itis.IGOR_ASTAFYEV.advices.RegistrationAfterAdvice;
import ru.kpfu.itis.IGOR_ASTAFYEV.advices.RegistrationBeforeAdvice;
import ru.kpfu.itis.IGOR_ASTAFYEV.model.Users;
import ru.kpfu.itis.IGOR_ASTAFYEV.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registr")
public class RegistrationServlet extends HttpServlet {
    public static String newUser = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        String mail = request.getParameter("mail");
        String sport = request.getParameter("sport");
        if (sport.equals("Футбол"))
            sport = "Football";
        if (sport.equals("Баскетбол"))
            sport = "Basketball";
        if (sport.equals("Волейбол"))
            sport = "Volleyball";
        if (sport.equals("Хоккей"))
            sport = "Hockey";
        if (sport.equals("Теннис"))
            sport = "Tennis";
        HashSet<Users> users = UserRepository.getAllUsers();
        try {
            for (Users u : users) {
                if (u.getLogin().equals(username)) {
                    response.sendRedirect("/regEx");
                    return;
                }
                if (u.getMail().equals(mail)) {
                    response.sendRedirect("/regEx");
                    return;
                }
            }

            UserRepository ur = new UserRepository();
            ProxyFactory pf = new ProxyFactory(ur);
            pf.addAdvice(new RegistrationBeforeAdvice()); // before-совет
            pf.addAdvice(new RegistrationAfterAdvice()); // after-совет
            UserRepository ru = (UserRepository) pf.getProxy();
            ru.addNewUser(username, password, age, mail, sport);
            newUser = username;

            session.setAttribute("mail", mail);
            session.setAttribute("sport", sport);
            session.setAttribute("age", age);
            session.setAttribute("password", password);
            session.setAttribute("username", username);
            response.sendRedirect("/profile");
        } catch (Exception ignored) {
        }
    }
}
