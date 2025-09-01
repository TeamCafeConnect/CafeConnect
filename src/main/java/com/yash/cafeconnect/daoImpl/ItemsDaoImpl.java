package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.ItemsDao;
import com.yash.cafeconnect.entity.Items;

import java.sql.*;

public class ItemsDaoImpl implements ItemsDao {

    private static final String URL = "jdbc:mysql://localhost:3306/cafe";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static{
        try{
            Class.forName("com.mysql.cj.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    @Override
    public void addItems(Items item) {
        String sql = "Insert into Items(itemId,itemQuantity,price,menuId,description)values (?,?,?,?,?)";
        try(Connection connection = getConnection();
            PreparedStatement pst = connection.prepareStatement(sql)){
            pst.setInt(1, item.getItemId());
            pst.setInt(2, item.getItemQuantity());
            pst.setDouble(3, item.getPrice());
            pst.setInt(4, item.getMenuId());
            pst.setString(5, item.getDescription());
            pst.executeUpdate();

        }
        catch (Exception e){
            e.printStackTrace();

        }
    }

    @Override
    public void updateItems(Items item) {
        String sql = "UPDATE Items SET itemQuantity = ?, price = ?, menuId = ?, description = ? WHERE itemId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, item.getItemQuantity());
            pst.setDouble(2, item.getPrice());
            pst.setInt(3, item.getMenuId());
            pst.setString(4, item.getDescription());
            pst.setInt(5, item.getItemId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Items getItemById(int ItemId) {

        String sql = "SELECT * FROM Items WHERE itemId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {
            pst.setInt(1, ItemId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Items item = new Items();
                    item.setItemId(rs.getInt("itemId"));
                    item.setItemQuantity(rs.getInt("itemQuantity"));
                    item.setPrice(rs.getFloat("price"));
                    item.setMenuId(rs.getInt("menuId"));
                    item.setDescription(rs.getString("description"));
                    return item;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void deleteItem(int ItemId) {
        String sql = "delete from items where ItemId = ?";
        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,ItemId);
            pstmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
