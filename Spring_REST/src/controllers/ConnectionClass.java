package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
    protected static Connection con;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (con == null) {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/DBforSpring",
                    "postgres",
                    "123456"
            );
        }
        return con;
    }
}