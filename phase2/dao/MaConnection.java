package com.example.phase1.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MaConnection {
    public static Connection connection;
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/educational_management_system?useSSL=false","root","");
            System.out.print("Connected");

        } catch (Exception e) {
            System.out.print("not connected");

            e.printStackTrace();
        }
        return connection;
    }

}
