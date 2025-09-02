package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.MenuDao;
import com.yash.cafeconnect.entity.Menu;
import com.yash.cafeconnect.util.DBConnect;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class MenuDaoImpl implements MenuDao {


    @Override
    public void addMenu(Menu menu) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "INSERT INTO menu (cafe_id, dish_name, price, description, item_id) VALUES (?, ?, ?, ?, ?)";
            pstmt = DBConnect.getPreparedStatement(connection, sql);
            pstmt.setInt(1, menu.getCafeId());
            pstmt.setString(2, menu.getDishName());
            pstmt.setDouble(3, menu.getPrice());
            pstmt.setString(4, menu.getDescription());
            pstmt.setInt(5, menu.getItemId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnection(connection);
        }
    }

    @Override
    public Menu getMenuById(int MenuId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = DBConnect.getConnection();
            pstmt = DBConnect.getPreparedStatement(connection, "SELECT * FROM menu WHERE menu_id = ?");
            pstmt.setInt(1, MenuId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Menu(
                        rs.getInt("menu_id"),
                        rs.getInt("cafe_id"),
                        rs.getString("dish_name"),
                        rs.getDouble("price"),
                        rs.getString("description"),
                        rs.getInt("item_id")
                );
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
        return null;
    }

    @Override
    public void updateMenu(Menu menu) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "UPDATE menu SET cafe_id = ?, dish_name = ?, price = ?, description = ?, item_id = ? WHERE menu_id = ?";
            pstmt = DBConnect.getPreparedStatement(connection, sql);
            pstmt.setInt(1, menu.getCafeId());
            pstmt.setString(2, menu.getDishName());
            pstmt.setDouble(3, menu.getPrice());
            pstmt.setString(4, menu.getDescription());
            pstmt.setInt(5, menu.getItemId());
            pstmt.setInt(6, menu.getMenuId()); // assuming menuId is primary key
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No menu found with id " + menu.getMenuId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnection(connection);
        }


    }

    @Override
    public void deleteMenu(int menuId) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = DBConnect.getConnection();
            String sql = "DELETE FROM menu WHERE menu_id = ?";
            pstmt = DBConnect.getPreparedStatement(connection, sql);
            pstmt.setInt(1, menuId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No menu found with ID " + menuId + " to delete.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnect.closePreparedStatement(pstmt);
            DBConnect.closeConnection(connection);
        }

    }
}





