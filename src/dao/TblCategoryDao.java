/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.TblCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class TblCategoryDao {

    public List<TblCategory> getAllCategories() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select categoryId, categoryName, description "
                        + "from TblCategories";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                List<TblCategory> categories = new ArrayList<>();
                while (rs.next()) {
                    String categoryId = rs.getString("categoryId");
                    String name = rs.getString("categoryName");
                    String description = rs.getString("description");
                    TblCategory category = new TblCategory(categoryId, name, description);
                    categories.add(category);
                }
                return categories;
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
    
    public TblCategory saveCategory(TblCategory category) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "insert into TblCategories(categoryId, categoryName, description) "
                        + "values(?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, category.getCategoryId());
                stm.setString(2, category.getName());
                stm.setString(3, category.getDescription());
                int result = stm.executeUpdate();
                if (result == 1) {
                    return category;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }
    
    public TblCategory updateCategory(TblCategory category) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "update TblCategories "
                        + "set categoryName = ?, description = ? "
                        + "where categoryId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, category.getName());
                stm.setString(2, category.getDescription());
                stm.setString(3, category.getCategoryId());
                int result = stm.executeUpdate();
                if (result == 1) {
                    return category;
                }
            }
        } finally {
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
