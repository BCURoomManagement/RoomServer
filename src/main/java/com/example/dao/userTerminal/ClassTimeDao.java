package com.example.dao.userTerminal;

import com.example.entity.userTerminal.Index;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassTimeDao {
    DBUtil util = new DBUtil();
    public List<Index> gettime(String typee,String date,int [] a) {
        String [] b = new String[] {"one","two","three","four","five","six","seven","eight","nine","ten","tone","ttwo","tthree","tfour"};
        String c = "";
        for(int i = 1 ; i<15 ; i++){
            if(a[i]==1){
                c=c+" and "+b[i-1]+"=0";
            }
        }
        System.out.println(c);

        String sql2 = c;
        String sql = "SELECT * FROM UseRoom.classroom WHERE typee = ? and classroom.roomid IN (select roomid from UseRoom.usemode where  data ="+date+sql2+")";
        System.out.println(sql);
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,typee);
            ResultSet rs = pstmt.executeQuery();
            List<Index> list2 = new ArrayList<Index>();
            while (rs.next()) {
                Index message2 = new Index();
                message2.setRoomid(rs.getString(1));
                message2.setTypee(rs.getString(2));
                message2.setPlace(rs.getString(3));
                message2.setPicture(rs.getString(4));
                message2.setPeoplenum(rs.getString(5));
                message2.setWifi(rs.getString(6));
                message2.setProjector(rs.getString(7));
                message2.setRoomcomputer(rs.getString(8));
                message2.setDoorlock(rs.getString(9));
                message2.setWired(rs.getString(10));
                message2.setTouchtv(rs.getString(11));
                message2.setStucomputer(rs.getString(12));
                message2.setActdesks(rs.getString(13));
                message2.setAio(rs.getString(14));
                message2.setMeetingsys(rs.getString(15));
                message2.setAircolo(rs.getString(16));
                message2.setDesks(rs.getString(17));
                list2.add(message2);
            }
            conn.close();
            return list2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int [] stt(String [] a) {
        int [] result = new int [a.length];
        for (int i = 0;i<a.length;i++){
            result[i] = Integer.parseInt(a[i]);
        }
        return result;

    }
}
