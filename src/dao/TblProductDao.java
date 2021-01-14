/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.TblCategory;
import entity.TblProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBUtils;

public class TblProductDao {

    public List<TblProduct> getAllProducts() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "select productId, productName, unit, price, quantity, categoryId "
                        + "from TblProducts";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                List<TblProduct> products = new ArrayList<>();
                while (rs.next()) {
                    String id = rs.getString("productId");
                    String name = rs.getString("productName");
                    String unit = rs.getString("unit");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    String categoryId = rs.getString("categoryId");
                    TblProduct product = new TblProduct(id, name, unit, price,
                            quantity, categoryId);
                    products.add(product);
                }
                return products;
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

    public TblProduct saveProduct(TblProduct product) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "insert into TblProducts(productId, productName, "
                        + "unit, price, quantity, categoryId) "
                        + "values(?, ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, product.getProductId());
                stm.setString(2, product.getName());
                stm.setString(3, product.getUnit());
                stm.setFloat(4, product.getPrice());
                stm.setInt(5, product.getQuantity());
                stm.setString(6, product.getCategoryId());
                int result = stm.executeUpdate();
                if (result == 1) {
                    return product;
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

    public TblProduct updateProduct(TblProduct product) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "update TblProducts "
                        + "set productName = ?, unit = ?, price = ?, quantity = ?, "
                        + "categoryId = ? "
                        + "where productId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, product.getName());
                stm.setString(2, product.getUnit());
                stm.setFloat(3, product.getPrice());
                stm.setInt(4, product.getQuantity());
                stm.setString(5, product.getCategoryId());
                stm.setString(5, product.getProductId());
                int result = stm.executeUpdate();
                if (result == 1) {
                    return product;
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

    public TblProduct deleteProduct(TblProduct product) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "delete from TblProducts "
                        + "where productId = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, product.getProductId());
                int result = stm.executeUpdate();
                if (result == 1) {
                    return product;
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
