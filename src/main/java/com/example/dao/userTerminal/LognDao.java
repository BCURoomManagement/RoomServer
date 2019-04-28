package com.example.dao.userTerminal;

import com.example.entity.userTerminal.Logn;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LognDao {
    DBUtil util = new DBUtil();
    public List<Logn> getlogn(String us,String ps) {

        String sql = "select name,department,studentnumber from UseRoom.user where username= ? and password=?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,us);
            pstmt.setString(2,ps);
            ResultSet rs = pstmt.executeQuery();

            List<Logn> list = new ArrayList<Logn>();
            while (rs.next()) {
                Logn message = new Logn();
                message.setName(rs.getString(1));
                message.setDepartment(rs.getString(2));
                message.setStudentnumber(rs.getString(3));
                list.add(message);
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Logn> getlognM(String us,String ps) {

        String sql = "select permission,name,department,studentnumber from UseRoom.user where username= ? and password=?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,us);
            pstmt.setString(2,ps);
            ResultSet rs = pstmt.executeQuery();

            List<Logn> list = new ArrayList<Logn>();
            while (rs.next()) {
                Logn message = new Logn();
                message.setPermission(rs.getString(1));
                message.setName(rs.getString(2));
                message.setDepartment(rs.getString(3));
                message.setStudentnumber(rs.getString(4));
                list.add(message);
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
