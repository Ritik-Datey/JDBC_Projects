package com.cmspackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
    private static final String URL = "jdbc:mysql://localhost:3306/daily_collection";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ragnar@123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    
}
