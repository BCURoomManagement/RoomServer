package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn= DriverManager.getConnection("jdbc:mysql://39.106.70.44:3306/UseRoom","root","root");
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
