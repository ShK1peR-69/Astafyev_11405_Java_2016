package ru.kpfu.itis.IGOR_ASTAFYEV.repository;

import ru.kpfu.itis.IGOR_ASTAFYEV.controller.ConnectionClass;
import ru.kpfu.itis.IGOR_ASTAFYEV.model.Histories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class HistoriesRepository {

    public static String getHistory(String game) {
        HashSet<Histories> his = new HashSet<>();
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        String history = null;
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM HISTORIES WHERE GAME_NAME = ?;");
            stmt.setString(1, game);
            rs = stmt.executeQuery();
            while (rs.next()) {
                his.add(new Histories((rs.getString("game_name")),
                        (rs.getString("article")),
                        (rs.getString("head"))));
            }
            for(Histories h: his){
                if(h.getGame_name().equals(game))
                    history = h.getArticle();
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return history;
    }
}