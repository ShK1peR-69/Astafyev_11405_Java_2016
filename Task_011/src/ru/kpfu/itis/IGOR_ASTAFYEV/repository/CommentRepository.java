package ru.kpfu.itis.IGOR_ASTAFYEV.repository;

import org.json.JSONArray;
import ru.kpfu.itis.IGOR_ASTAFYEV.controller.ConnectionClass;
import ru.kpfu.itis.IGOR_ASTAFYEV.model.Comments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

/**
 * @author Astafyev Igor
 *         11-405
 */
public class CommentRepository {

    public static JSONArray getNewsComment() {
        Connection conn;
        PreparedStatement stmt;
        HashSet<Comments> comm = new HashSet<>();
        ResultSet rs;
        JSONArray ja = null;
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM COMMENTS WHERE PAGE = 'news';");
            rs = stmt.executeQuery();
            ja = new JSONArray();
            while (rs.next()) {
                comm.add(new Comments(((rs.getString("author"))),
                        (rs.getString("comm")),
                        (rs.getString("page"))));
                ja.put("<h3><b>" + rs.getString("author") + ":</b></h3>" + rs.getString("comm") + "<br/>");
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }

    public static JSONArray getPhotosComment() {
        Connection conn;
        PreparedStatement stmt;
        HashSet<Comments> comm = new HashSet<>();
        ResultSet rs;
        JSONArray ja = null;
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM COMMENTS WHERE PAGE = 'photos';");
            rs = stmt.executeQuery();
            ja = new JSONArray();
            while (rs.next()) {
                comm.add(new Comments(((rs.getString("author"))),
                        (rs.getString("comm")),
                        (rs.getString("page"))));
                ja.put("<h3><b>" + rs.getString("author") + ":</b></h3>" + rs.getString("comm") + "<br/>");
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }

    public static JSONArray getVideosComment() {
        Connection conn;
        PreparedStatement stmt;
        HashSet<Comments> comm = new HashSet<>();
        ResultSet rs;
        JSONArray ja = null;
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM COMMENTS WHERE PAGE = 'videos';");
            rs = stmt.executeQuery();
            ja = new JSONArray();
            while (rs.next()) {
                comm.add(new Comments(((rs.getString("author"))),
                        (rs.getString("comm")),
                        (rs.getString("page"))));
                ja.put("<h3><b>" + rs.getString("author") + ":</b></h3>" + rs.getString("comm") + "<br/>");
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return ja;
    }

    public static void addNewComment(String author, String comm, String page)
            throws SQLException, ClassNotFoundException {
        Connection conn;
        PreparedStatement stmt;
        conn = ConnectionClass.getConnection();
        stmt = conn.prepareStatement("INSERT INTO COMMENTS(AUTHOR, COMM, PAGE) VALUES(?,?,?)");
        stmt.setString(1, author);
        stmt.setString(2, comm);
        stmt.setString(3, page);
        if (stmt.executeUpdate() < 1) {
            return;
        }
        stmt.close();
    }
}
