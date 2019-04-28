package com.example.dao.managementTerminal;

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

    public boolean approval(String time, String username, String pass,String noinf) {

        String sql = "update UseRoom.brecrord set pass = ?,noinf = ?  where submission = ? and username = ?";
        System.out.println(sql);
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pass);
            pstmt.setString(2, noinf);
            pstmt.setString(3, time);
            pstmt.setString(4, username);
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

    public List<Record> selBre(String username,String submission){
        String sql = "select * from UseRoom.brecrord where username=? and submission=? ";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,submission);
            ResultSet rs = pstmt.executeQuery();

            List<Record> list = new ArrayList<Record>();
            while (rs.next()) {
                Record message = new Record();
                message.setUsername(rs.getString(1));
                message.setUse(rs.getString(2));
                message.setPhone(rs.getString(3));
                message.setData(rs.getString(4));
                message.setOne(rs.getString(5));
                message.setTwo(rs.getString(6));
                message.setThree(rs.getString(7));
                message.setFour(rs.getString(8));
                message.setFive(rs.getString(9));
                message.setSix(rs.getString(10));
                message.setSeven(rs.getString(11));
                message.setEight(rs.getString(12));
                message.setNine(rs.getString(13));
                message.setTen(rs.getString(14));
                message.setTone(rs.getString(15));
                message.setTtwo(rs.getString(16));
                message.setTthree(rs.getString(17));
                message.setTfour(rs.getString(18));
                message.setRoomid(rs.getString(19));
                message.setPass(rs.getString(20));
                message.setSubmission(rs.getString(21));
                message.setFtime(rs.getString(22));
                message.setLtime(rs.getString(23));
                message.setNoinf(rs.getString(24));
                list.add(message);
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
                message.setNoinf(rs.getString(24));
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

        String sql = "select * from UseRoom.brecrord order by submission desc";
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
