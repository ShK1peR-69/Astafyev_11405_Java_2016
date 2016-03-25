package ru.kpfu.itis.IGOR_ASTAFYEV.repository;

import org.json.JSONArray;
import ru.kpfu.itis.IGOR_ASTAFYEV.controller.ConnectionClass;
import ru.kpfu.itis.IGOR_ASTAFYEV.model.Tables;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class TablesRepository {

    public static JSONArray getTable(String game) {
        HashSet<Tables> tab = new HashSet<>();
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        JSONArray ja = null;
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM MYTABLES WHERE GAME=?;");
            stmt.setString(1, game);
            rs = stmt.executeQuery();
            ja = new JSONArray();
            while (rs.next()) {
                tab.add(new Tables((rs.getString("game")),
                        (new Integer(rs.getString("pos"))),
                        (rs.getString("team")),
                        (new Integer(rs.getString("points")))));
                ja.put("<tr align='center'>" +
                        "<td width='80px'>" + rs.getString("pos") + "</td><td width='300px'>" +
                        rs.getString("team") + "</td><td width='100px'>" + rs.getString("points") + "</td>" +
                        "</tr>");
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }
}