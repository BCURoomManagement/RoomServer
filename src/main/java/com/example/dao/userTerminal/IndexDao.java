package com.example.dao.userTerminal;

import com.example.entity.userTerminal.Index;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexDao {
    DBUtil util = new DBUtil();
    public List<Index> getOneRoom(String te) {

        String sql = "select * from UseRoom.classroom where typee= ?  ";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,te);
            ResultSet rs = pstmt.executeQuery();

            List<Index> list = new ArrayList<Index>();
            while (rs.next()) {
                Index message = new Index();
                message.setRoomid(rs.getString(1));
                message.setTypee(rs.getString(2));
                message.setPlace(rs.getString(3));
                message.setPicture(rs.getString(4));
                message.setPeoplenum(rs.getString(5));
                message.setWifi(rs.getString(6));
                message.setProjector(rs.getString(7));
                message.setRoomcomputer(rs.getString(8));
                message.setDoorlock(rs.getString(9));
                message.setWired(rs.getString(10));
                message.setTouchtv(rs.getString(11));
                message.setStucomputer(rs.getString(12));
                message.setActdesks(rs.getString(13));
                message.setAio(rs.getString(14));
                message.setMeetingsys(rs.getString(15));
                message.setAircolo(rs.getString(16));
                message.setDesks(rs.getString(17));
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
