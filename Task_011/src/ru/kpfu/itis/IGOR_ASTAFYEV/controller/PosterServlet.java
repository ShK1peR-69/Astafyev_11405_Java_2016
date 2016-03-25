package ru.kpfu.itis.IGOR_ASTAFYEV.controller;

import org.json.JSONException;
import org.json.JSONObject;
import ru.kpfu.itis.IGOR_ASTAFYEV.repository.PosterRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "PosterServlet", urlPatterns = "/poster?get=matches")
public class PosterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        JSONObject jo = new JSONObject();
        try {
            jo.put("presult", PosterRepository.getPoster());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.getWriter().print(jo.toString());
        response.sendRedirect("/poster");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}