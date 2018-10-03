package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/UseRoom?useUnicode=true&characterEncoding=utf8","root","rootroot");
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
