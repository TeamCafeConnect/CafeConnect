package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.ItemsDao;
import com.yash.cafeconnect.entity.Items;
import com.yash.cafeconnect.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemsDaoImpl implements ItemsDao {

    @Override
    public void addItems(Items item) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "INSERT INTO items (item_quantity, price, menu_id, description) VALUES (?, ?, ?, ?)";
            pstmt = DBConnect.getPreparedStatement(connection, sql);
            pstmt.setInt(1, item.getItemQuantity());
            pstmt.setDouble(2, item.getPrice());
            pstmt.setInt(3, item.getMenuId());
            pstmt.setString(4, item.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnection(connection);
        }

    }

    @Override
    public void updateItems(Items item) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "UPDATE items SET item_quantity = ?, price = ?, menu_id = ?, description = ? WHERE item_id = ?";
            pstmt = DBConnect.getPreparedStatement(connection, sql);
            pstmt.setInt(1, item.getItemQuantity());
            pstmt.setFloat(2, item.getPrice());
            pstmt.setInt(3, item.getMenuId());
            pstmt.setString(4, item.getDescription());
            pstmt.setInt(5, item.getItemId());
            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated == 0) {
                System.out.println("No item found with ID " + item.getItemId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnection(connection);
        }

    }

    @Override
    public Items getItemById(int ItemId) {
        Items item = null;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "SELECT item_id, item_quantity, price, menu_id, description FROM items WHERE item_id = ?";
            pstmt = DBConnect.getPreparedStatement(connection, sql);
            pstmt.setInt(1, ItemId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                item = new Items();
                item.setItemId(rs.getInt("item_id"));
                item.setItemQuantity(rs.getInt("item_quantity"));
                item.setPrice(rs.getFloat("price"));
                item.setMenuId(rs.getInt("menu_id"));
                item.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnection(connection);
        }
        return item;
    }

    @Override
    public void deleteItem(int ItemId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "DELETE FROM items WHERE item_id = ?";
            pstmt = DBConnect.getPreparedStatement(connection, sql);
            pstmt.setInt(1, ItemId);
            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted == 0) {
                System.out.println("No item found with ID " + ItemId + " to delete.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnection(connection);
        }

    }
}
