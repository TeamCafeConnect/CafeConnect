package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.CafeDao;
import com.yash.cafeconnect.entity.Cafe;
import com.yash.cafeconnect.entity.enums.CafeStatus;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Implementation of CafeDao
 */
public class CafeDaoImpl implements CafeDao{

    private static final String URL = "jdbc:mysql://localhost:3306/cafe";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

    public void saveCafe(Cafe cafe){
        String sql = "INSERT INTO cafe (cafeId, cafeName, cafeStatus, companyId) VALUES(?,?,?,?)";
        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            pstmt.setInt(1, cafe.getCafeId());
            pstmt.setString(2, cafe.getCafeName());
            pstmt.setString(3,cafe.getCafeStatus().name());
            pstmt.setInt(4,cafe.getCompanyId());
            pstmt.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Cafe getCafe(int cafeId){
        String sql = "SELECT * FROM cafe WHERE cafeId =?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt= connection.prepareStatement(sql))
        {
            pstmt.setInt(1, cafeId);
            try (ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    int id = rs.getInt("cafeId");
                    String name = rs.getString("cafeName");
                    CafeStatus cafestatus = CafeStatus.valueOf(rs.getString("cafestatus"));
                    int companyId = rs.getInt("companyId");
                    return new Cafe(id, name, cafestatus, companyId);
                }
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateCafe(Cafe cafe){
        String sql = "UPDATE cafe SET cafeName = ?, cafeStatus = ?, companyId = ? WHERE cafeId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            pstmt.setString(1,cafe.getCafeName());
            pstmt.setString(2,cafe.getCafeStatus().name());
            pstmt.setInt(3,cafe.getCompanyId());
            pstmt.setInt(4,cafe.getCafeId());
            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCafe(int cafeId){
        String sql = "DELETE FROM cafe WHERE cafeId = ?";
        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            pstmt.setInt(1,cafeId);
            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Cafe> getCafes(){
        List<Cafe> cafes = new ArrayList<>();
        String sql = "SELECT * FROM cafe ORDER BY cafeId";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql))
        {
            while(rs.next()) {
                int id = rs.getInt("cafeId");
                String name = rs.getString("cafeName");
                CafeStatus cafestatus = CafeStatus.valueOf(rs.getString("cafestatus"));
                int companyId = rs.getInt("companyId");
                cafes.add(new Cafe(id,name,cafestatus,companyId));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cafes;
    }
}
