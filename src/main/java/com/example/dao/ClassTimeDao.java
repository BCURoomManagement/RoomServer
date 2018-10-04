package com.example.dao;

import com.example.entity.ClassTime;
import com.example.entity.Logn;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassTimeDao {
    DBUtil util = new DBUtil();
    public List<ClassTime> gettime(String date,int[] a) {
        String [] b = new String[] {"one","two","three","four","five","six","seven","eight","nine","ten","tone","ttwo","tthree","tfour"};
        String c = "1=1";
        for(int i = 1 ; i<15 ; i++){
            if(a[i]==1){
                c=c+" and "+b[i-1]+"=0";
            }
        }
        System.out.println(c);

        String sql2 = c;
        String sql = "select roomid from UseRoom.usemode where "+sql2+" and data = "+date;
        System.out.println(sql);
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<ClassTime> list = new ArrayList<ClassTime>();
            while (rs.next()) {
                ClassTime message = new ClassTime();
                message.setRoomid(rs.getString(1));
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
