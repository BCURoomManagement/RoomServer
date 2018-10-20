package com.example.dao;

import com.example.entity.ClassTime;
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
            pstmt.setString(1, uname);
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

    public boolean instertSubmit(String username, String use, String data, String a[], String roomid, String pass, String submission) {

        String sql = "insert into UseRoom.brecrord values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, use);
            pstmt.setString(3, data);
            pstmt.setString(4, a[0]);
            pstmt.setString(5, a[1]);
            pstmt.setString(6, a[2]);
            pstmt.setString(7, a[3]);
            pstmt.setString(8, a[4]);
            pstmt.setString(9, a[5]);
            pstmt.setString(10, a[6]);
            pstmt.setString(11, a[7]);
            pstmt.setString(12, a[8]);
            pstmt.setString(13, a[9]);
            pstmt.setString(14, a[10]);
            pstmt.setString(15, a[11]);
            pstmt.setString(16, a[12]);
            pstmt.setString(17, a[13]);
            pstmt.setString(18, roomid);
            pstmt.setString(19, pass);
            pstmt.setString(20, submission);
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

    public List<ClassTime> gettime(String roomid, String date) {

        String sql = "select roomid,one,two,three,four,five,six,seven,eight,nine,ten,tone,ttwo,tthree,tfour from UseRoom.usemode where roomid = ? and data = ?";
        System.out.println(sql);
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, roomid);
            pstmt.setString(2, date);
            ResultSet rs = pstmt.executeQuery();
            List<ClassTime> list2 = new ArrayList<ClassTime>();
            while (rs.next()) {
                ClassTime message = new ClassTime();
                message.setRoomid(rs.getString(1));
                message.setOne(rs.getString(2));
                message.setTwo(rs.getString(3));
                message.setThree(rs.getString(4));
                message.setFour(rs.getString(5));
                message.setFive(rs.getString(6));
                message.setSix(rs.getString(7));
                message.setSeven(rs.getString(8));
                message.setEight(rs.getString(9));
                message.setNine(rs.getString(10));
                message.setTen(rs.getString(11));
                message.setTone(rs.getString(12));
                message.setTtwo(rs.getString(13));
                message.setTthree(rs.getString(14));
                message.setTfour(rs.getString(15));
                list2.add(message);
            }
            conn.close();
            return list2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean chack(List<ClassTime> list, String a[]) {

            System.out.println(list.get(0).getTthree());


            if (list.get(0).getOne().equals("1") && list.get(0).getOne().equals(a[0])) {
                return false;
            }
            else if (list.get(0).getTwo().equals("1") && list.get(0).getTwo().equals(a[1])){
                return false;
            }
            else if (list.get(0).getThree().equals("1") && list.get(0).getThree().equals(a[2])){
                return false;
            }
            else if (list.get(0).getFour().equals("1") && list.get(0).getFour().equals(a[3])){
                return false;
            }
            else if (list.get(0).getFive().equals("1") && list.get(0).getFive().equals(a[4])){
                return false;
            }
            else if (list.get(0).getSix().equals("1") && list.get(0).getSix().equals(a[5])){
                return false;
            }
            else if (list.get(0).getSeven().equals("1") && list.get(0).getSeven().equals(a[6])){
                return false;
            }
            else if (list.get(0).getEight().equals("1") && list.get(0).getEight().equals(a[7])){
                return false;
            }
            else if (list.get(0).getNine().equals("1") && list.get(0).getNine().equals(a[8])){
                return false;
            }
            else if (list.get(0).getTen().equals("1") && list.get(0).getTen().equals(a[9])){
                return false;
            }
            else if (list.get(0).getTone().equals("1") && list.get(0).getTone().equals(a[10])){
                return false;
            }
            else if (list.get(0).getTtwo().equals("1") && list.get(0).getTtwo().equals(a[11])){
                return false;
            }
            else if (list.get(0).getTthree().equals("1") && list.get(0).getTthree().equals(a[12])){
                return false;
            }
            else if (list.get(0).getTfour().equals("1") && list.get(0).getTfour().equals(a[13])){
                return false;
            }
            else{
                return true;
            }

    }

}
