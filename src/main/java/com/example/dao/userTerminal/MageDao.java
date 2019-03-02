package com.example.dao.userTerminal;

import com.example.entity.userTerminal.Mage;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MageDao {
    DBUtil util = new DBUtil();
    public List<Mage> getMassage() {

        String sql = "select * from UseRoom.mage  ";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            List<Mage> list = new ArrayList<Mage>();
            while (rs.next()) {
                Mage message = new Mage();
                message.setId(rs.getString(1));
                message.setMassage(rs.getString(2));
                message.setTime(rs.getString(3));
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
