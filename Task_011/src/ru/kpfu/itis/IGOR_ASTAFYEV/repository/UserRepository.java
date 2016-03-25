package ru.kpfu.itis.IGOR_ASTAFYEV.repository;

import ru.kpfu.itis.IGOR_ASTAFYEV.controller.ConnectionClass;
import ru.kpfu.itis.IGOR_ASTAFYEV.model.Users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class UserRepository {

    public static HashSet<Users> getAllUsers() {
        Connection conn;
        PreparedStatement stmt;
        HashSet<Users> us = new HashSet<>();
        ResultSet rs;
        try {
            conn = ConnectionClass.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM USERS;");
            rs = stmt.executeQuery();
            while (rs.next()) {
                us.add(new Users(rs.getString("login"),
                        rs.getString("pass"),
                        new Integer(rs.getString("age")),
                        rs.getString("mail"),
                        rs.getString("sport")));
            }
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return us;
    }

    public static String hashPass(String password) {
        MessageDigest messageDigest;
        byte[] hp = new byte[0];
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            hp = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return new String(hp);
    }


    public void addNewUser(String login, String pass, int age, String mail, String sport) {
        Connection conn;
        PreparedStatement stmt;

        try {
            conn = ConnectionClass.getConnection();

            stmt = conn.prepareStatement("INSERT INTO USERS(LOGIN, PASS, AGE, MAIL, SPORT) VALUES(?,?,?,?,?);");

            stmt.setString(1, login);
            stmt.setString(2, hashPass(pass));
            stmt.setInt(3, age);
            stmt.setString(4, mail);
            stmt.setString(5, sport);

            stmt.executeUpdate();
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}