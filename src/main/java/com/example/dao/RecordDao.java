package com.example.dao;

import com.example.entity.Record;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordDao {
    DBUtil util = new DBUtil();
    public List<Record> getRecord(String uname) {

        String sql = "select * from UseRoom.brecrord where username = ?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,uname);
            ResultSet rs = pstmt.executeQuery();

            List<Record> list = new ArrayList<Record>();
            while (rs.next()) {
                Record message = new Record();
                message.setUsername(rs.getString(1));
                message.setUse(rs.getString(2));
                message.setData(rs.getString(3));
                message.setOne(rs.getString(4));
                message.setTwo(rs.getString(5));
                message.setThree(rs.getString(6));
                message.setFour(rs.getString(7));
                message.setFive(rs.getString(8));
                message.setSix(rs.getString(9));
                message.setSeven(rs.getString(10));
                message.setEight(rs.getString(11));
                message.setNine(rs.getString(12));
                message.setTen(rs.getString(13));
                message.setTone(rs.getString(14));
                message.setTtwo(rs.getString(15));
                message.setThree(rs.getString(16));
                message.setTfour(rs.getString(17));
                message.setRoomid(rs.getString(18));
                message.setPass(rs.getString(19));
                message.setSubmission(rs.getString(20));
                list.add(message);
            }
            conn.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean instertSubmit(String username,String use,String data,String a [],String roomid,String pass,String submission){
        String sql = "insert into UseRoom.brecrord values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,use);
            pstmt.setString(3,data);
            pstmt.setString(4,a[0]);
            pstmt.setString(5,a[1]);
            pstmt.setString(6,a[2]);
            pstmt.setString(7,a[3]);
            pstmt.setString(8,a[4]);
            pstmt.setString(9,a[5]);
            pstmt.setString(10,a[6]);
            pstmt.setString(11,a[7]);
            pstmt.setString(12,a[8]);
            pstmt.setString(13,a[9]);
            pstmt.setString(14,a[10]);
            pstmt.setString(15,a[11]);
            pstmt.setString(16,a[12]);
            pstmt.setString(17,a[13]);
            pstmt.setString(18,roomid);
            pstmt.setString(19,pass);
            pstmt.setString(20,submission);
            if (pstmt.executeUpdate()>0){
                conn.close();
                return true;
            }
            else {
                conn.close();
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
