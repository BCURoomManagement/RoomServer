package com.example.dao.managementTerminal;

import com.example.entity.userTerminal.ClassTime;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryStatusDao {
    DBUtil util = new DBUtil();
    public List<ClassTime> getStatusByData(String data) {

        String sql = "select * from UseRoom.usemode where data=? order by roomid desc ";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,data);
            ResultSet rs = pstmt.executeQuery();

            List<ClassTime> list = new ArrayList<ClassTime>();
            while (rs.next()) {
                ClassTime message = new ClassTime();
                message.setRoomid(rs.getString(1));
                message.setData(rs.getString(2));
                message.setOne(rs.getString(3));
                message.setTwo(rs.getString(4));
                message.setThree(rs.getString(5));
                message.setFour(rs.getString(6));
                message.setFive(rs.getString(7));
                message.setSix(rs.getString(8));
                message.setSeven(rs.getString(9));
                message.setEight(rs.getString(10));
                message.setNine(rs.getString(11));
                message.setTen(rs.getString(12));
                message.setTone(rs.getString(13));
                message.setTtwo(rs.getString(14));
                message.setTthree(rs.getString(15));
                message.setTfour(rs.getString(16));
                list.add(message);
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<ClassTime> getStatusByRoom(String data,String roomid) {
        //int datali = Integer.parseInt(data)+6;
        //String datal = String.valueOf(datali);
        //String sql = "select * from UseRoom.usemode where ?<=data and data<=? and roomid = ? order by roomid desc ";
        String sql = "select * from UseRoom.usemode where data=? and roomid = ? order by roomid desc ";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,data);
            //pstmt.setString(2,datal);
            pstmt.setString(2,roomid);
            ResultSet rs = pstmt.executeQuery();

            List<ClassTime> list = new ArrayList<ClassTime>();
            while (rs.next()) {
                ClassTime message = new ClassTime();
                message.setRoomid(rs.getString(1));
                message.setData(rs.getString(2));
                message.setOne(rs.getString(3));
                message.setTwo(rs.getString(4));
                message.setThree(rs.getString(5));
                message.setFour(rs.getString(6));
                message.setFive(rs.getString(7));
                message.setSix(rs.getString(8));
                message.setSeven(rs.getString(9));
                message.setEight(rs.getString(10));
                message.setNine(rs.getString(11));
                message.setTen(rs.getString(12));
                message.setTone(rs.getString(13));
                message.setTtwo(rs.getString(14));
                message.setTthree(rs.getString(15));
                message.setTfour(rs.getString(16));
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
