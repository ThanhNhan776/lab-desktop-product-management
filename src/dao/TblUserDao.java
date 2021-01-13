/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import entity.TblUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import utils.DBUtils;


public class TblUserDao {
    public TblUser getUser(String username, String password) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select userId, fullName from TblUsers "
                        + "where userId = ? and password = ? and status = 1";
                stm = con.prepareStatement(sql);
                stm.setString(1, username); // position count from 1
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String userId = rs.getString("userId");
                    String fullName = rs.getString("fullName");
                    return new TblUser(userId, fullName, null, true);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
}
