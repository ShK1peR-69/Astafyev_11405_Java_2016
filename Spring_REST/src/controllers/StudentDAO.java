package controllers;

import domain.Student;
import org.json.JSONException;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Astafyev Igor
 *         11-405
 */

public class StudentDAO {

    @ResponseBody
    public List<Student> getAll() throws JSONException {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs = null;
        List<Student> st = new ArrayList<>();
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM STUDENTS;");

            while (rs.next()) {
                st.add(new Student(new Integer(rs.getString("id")),
                        rs.getString("name")));
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return st;
    }


    @ResponseBody
    public Student getStudentByID(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs = null;
        Student student = new Student();
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT NAME FROM STUDENTS WHERE ID=?;");

            stmt.setString(1, String.valueOf(id));

            student.setName(rs.getString("name"));

            stmt.executeUpdate();
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @ResponseBody
    public void deleteUserByID(int id) {
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs = null;
        Student student = new Student();
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("DELETE * FROM STUDENTS WHERE ID=?;");

            stmt.setString(1, String.valueOf(id));

            student.setName(rs.getString("name"));

            stmt.executeUpdate();
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
