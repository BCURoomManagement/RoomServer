package com.example.dao.userTerminal;

import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubmitDao {
    DBUtil util = new DBUtil();

    public boolean upad(String roomid, String data, int a[]) {
        String[] b = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "tone", "ttwo", "tthree", "tfour"};
        String c = "";
        for (int i = 0; i < 14; i++) {
            if (a[i] == 1) {
                c = c + " , " + b[i] + "=1";
            }
        }
        String c2 = c.substring(3, c.length());
        System.out.println(c);
        String sql = "update UseRoom.usemode set " + c2 + " where roomid = ? and data = ?";
        System.out.println(sql);
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, roomid);
            pstmt.setString(2, data);
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
}
