package ru.kpfu.itis.IGOR_ASTAFYEV.repository;

import org.json.JSONArray;
import ru.kpfu.itis.IGOR_ASTAFYEV.controller.ConnectionClass;
import ru.kpfu.itis.IGOR_ASTAFYEV.model.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class NewsRepository {

    public static JSONArray getNews(String game) {
        HashSet<News> n = new HashSet<>();
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        JSONArray ja = null;
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM NEWS WHERE SPORT = ?;");
            stmt.setString(1, game);
            rs = stmt.executeQuery();
            ja = new JSONArray();
            while (rs.next()) {
                n.add(new News((rs.getString("sport")),
                        (rs.getString("title")),
                        (rs.getString("article"))));
                ja.put("<div class='newme'><h2><b>" + rs.getString("title") + "</b></h2></p>"
                        + rs.getString("article") + "<br/><br/></div>");
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }
}