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
                message.setTime(rs.getString(4));
                message.setMessage(rs.getString(5));
                message.setPass(rs.getString(6));
                message.setSubmission(rs.getString(7));
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
