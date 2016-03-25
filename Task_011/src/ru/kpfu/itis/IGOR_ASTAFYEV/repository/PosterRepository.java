package ru.kpfu.itis.IGOR_ASTAFYEV.repository;

import org.json.JSONArray;
import ru.kpfu.itis.IGOR_ASTAFYEV.controller.ConnectionClass;
import ru.kpfu.itis.IGOR_ASTAFYEV.model.Poster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class PosterRepository {

    public static JSONArray getPoster() {
        HashSet<Poster> post = new HashSet<>();
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        JSONArray ja = null;
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM POSTER;");
            rs = stmt.executeQuery();
            ja  = new JSONArray();
            while (rs.next()) {
                post.add(new Poster((new Integer(rs.getString("id"))),
                        (rs.getString("sport")),
                        (rs.getString("mdate")),
                        (rs.getString("team_1")),
                        (rs.getString("team_2"))));
                ja.put(rs.getString("sport") + ". " + rs.getString("mdate") + ": " +
                        " " + rs.getString("team_1") + " - " + rs.getString("team_2") + ";<br/><br/>");
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }
}