package com.ufpr.tads.web2.dao;
//
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Ronaldo
 */
public class ConnectionFactory {
    public static Connection getConnection() {
        
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/trabalho_web", "postgres", "root");
           
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException (e);
        }
    }
}
