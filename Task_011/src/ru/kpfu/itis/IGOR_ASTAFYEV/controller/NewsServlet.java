package ru.kpfu.itis.IGOR_ASTAFYEV.controller;

import org.json.JSONException;
import org.json.JSONObject;
import ru.kpfu.itis.IGOR_ASTAFYEV.repository.NewsRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NewsServlet", urlPatterns = "/news/name")
public class NewsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        JSONObject jo = new JSONObject();
        try {
            jo.put("nresult", NewsRepository.getNews(request.getParameter("param")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.getWriter().print(jo.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
