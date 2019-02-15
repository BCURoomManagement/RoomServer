package com.example.dao.managementTerminal;

import com.example.entity.userTerminal.Index;
import com.example.entity.userTerminal.Record;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApprovalDao {
    DBUtil util = new DBUtil();

    public boolean approval(String time, String username, String pass) {

        String sql = "update UseRoom.brecrord set pass = ? where submission = ? and username = ?";
        System.out.println(sql);
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pass);
            pstmt.setString(2, time);
            pstmt.setString(3, username);
            if (pstmt.executeUpdate() > 0) {
                conn.close();
                return true;
            } else {
                conn.close();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Record> getApproval(String pass) {

        String sql = "select * from UseRoom.brecrord where pass=? order by submission desc ";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,pass);
            ResultSet rs = pstmt.executeQuery();

            List<Record> list = new ArrayList<Record>();
            while (rs.next()) {
                Record message = new Record();
                message.setUsername(rs.getString(1));
                message.setUse(rs.getString(2));
                message.setPhone(rs.getString(3));
                message.setData(rs.getString(4));
                message.setRoomid(rs.getString(19));
                message.setPass(rs.getString(20));
                message.setSubmission(rs.getString(21));
                message.setFtime(rs.getString(22));
                message.setLtime(rs.getString(23));
                list.add(message);
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Record> getAllApproval() {

        String sql = "select * from UseRoom.brecrord order by submission desc ";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Record> list = new ArrayList<Record>();
            while (rs.next()) {
                Record message = new Record();
                message.setUsername(rs.getString(1));
                message.setUse(rs.getString(2));
                message.setPhone(rs.getString(3));
                message.setData(rs.getString(4));
                message.setRoomid(rs.getString(19));
                message.setPass(rs.getString(20));
                message.setSubmission(rs.getString(21));
                message.setFtime(rs.getString(22));
                message.setLtime(rs.getString(23));
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
