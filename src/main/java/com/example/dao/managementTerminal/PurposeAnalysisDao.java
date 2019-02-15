package com.example.dao.managementTerminal;

import com.example.entity.userTerminal.Record;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurposeAnalysisDao {
    DBUtil util = new DBUtil();
    public List<Record> getPurposeAnalysis(String data,String roomid) {

        String sql = "select * from UseRoom.brecrord where pass=pass and data<=? and roomid=?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,data);
            pstmt.setString(2,roomid);
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
