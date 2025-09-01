package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.MenuDao;
import com.yash.cafeconnect.entity.Cafe;
import com.yash.cafeconnect.entity.Menu;
import com.yash.cafeconnect.util.DBConnect;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class MenuDaoImpl implements MenuDao {

    private static final String URL = "jdbc:mysql://localhost:3306/cafeconnect";
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
    public void addMenu(Menu menu) {
        String query = "insert into Menu(menuId,cafeId,dishName,price,description,itemId) values(?,?,?,?,?,?)";
       try(Connection connection = getConnection();
       PreparedStatement pst = connection.prepareStatement(query)){
           pst.setInt(1,menu.getMenuId());
           pst.setInt(2,menu.getCafeId());
           pst.setString(3,menu.getDishName());
           pst.setDouble(4,menu.getPrice());
           pst.setString(5,menu.getDescription());
           pst.setInt(6,menu.getItemId());
           pst.executeUpdate();
           


       }catch (Exception e)
       {
           e.printStackTrace();
       }
    }

    @Override
    public Menu getMenuById(int MenuId) {
        String query = "SELECT * FROM Menu WHERE menuId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, MenuId);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    Menu menu = new Menu();
                    menu.setMenuId(rs.getInt("menuId")); // always set ID
                    menu.setCafeId(rs.getInt("cafeId"));
                    menu.setDishName(rs.getString("dishName"));
                    menu.setPrice(rs.getDouble("price"));
                    menu.setDescription(rs.getString("description"));
                    menu.setItemId(rs.getInt("itemId"));
                    return menu;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateMenu(Menu menu) {
        String query = "Update Menu set cafeId = ?, dishName = ?,price = ?, description = ?, itemId = ? where menuId=?";
        try(Connection connection = getConnection();
            PreparedStatement pst = connection.prepareStatement(query)){
            pst.setInt(1,menu.getCafeId());
            pst.setString(2,menu.getDishName());
            pst.setDouble(3,menu.getPrice());
            pst.setString(4,menu.getDescription());
            pst.setInt(5,menu.getItemId());
            pst.setInt(6,menu.getMenuId());

            pst.executeUpdate();

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


    }

    @Override
    public void deleteMenu(int menuId) {
        String sql = "DELETE FROM Menu WHERE menuId = ?";
        try(Connection connection = getConnection();
            PreparedStatement pst = connection.prepareStatement(sql)){
            pst.setInt(1,menuId);
            pst.executeUpdate();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}





