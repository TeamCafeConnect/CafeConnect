package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.entity.Office;
import com.yash.cafeconnect.dao.OfficeDao;

import java.sql.*;

public class OfficeDaoImpl implements OfficeDao{

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

    public void saveOffice(Office office) {
        String sql = "INSERT INTO office (officeId, officeName, companyName, city) VALUES (?,?,?,?)";
        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            pstmt.setInt(1, office.getOfficeId());
            pstmt.setString(2, office.getOfficeName());
            pstmt.setString(3, office.getCompanyName());
            pstmt.setString(4, office.getCity());

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Office getOffice(int officeId){
        String sql = "SELECT * FROM office WHERE officeId = ?";
        try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            pstmt.setInt(1, officeId);
            try (ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    int id = rs.getInt("officeId");
                    String officeName = rs.getString("officeName");
                    String companyName = rs.getString("companyName");
                    String city = rs.getString("city");
                    return new Office(id,officeName,companyName,city);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void UpdateOffice(Office office) {
        String sql = "UPDATE  office SET officeName = ?, companyName = ?, city = ? WHERE officeId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            pstmt.setString(1,office.getOfficeName());
            pstmt.setString(2,office.getCompanyName());
            pstmt.setString(3,office.getCity());
            pstmt.setInt(4,office.getOfficeId());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteOffice(int officeId){
        String sql = "DELETE FROM office WHERE officeId = ?";
        try(Connection connection = getConnection();
        PreparedStatement pstmt =  connection.prepareStatement(sql))
        {
            pstmt.setInt(1, officeId);
            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
