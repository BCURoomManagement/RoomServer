package com.example.dao.userTerminal;

import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuestionDao {
    DBUtil util = new DBUtil();
    public boolean instertQuestion(String qmassage, String quser) {

        String sql = "insert into useroom.question (qmassage,quser) values (?,?)";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, qmassage);
            pstmt.setString(2, quser);
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
