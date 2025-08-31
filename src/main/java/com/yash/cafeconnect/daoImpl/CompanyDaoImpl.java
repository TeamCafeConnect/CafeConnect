//package com.yash.cafeconnect.daoImpl;
//
//import com.yash.cafeconnect.dao.CompanyDao;
//import com.yash.cafeconnect.entity.Company;
////import com.yash.cafeconnect.util;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class CompanyDaoImpl implements CompanyDao{
//
//    private static final String URL = "jdbc:mysql://localhost:3306/cafe";
//    private static final String USER = "root";
//    private static final String PASSWORD = "root";
//
//    static{
//        try{
//            Class.forName("com.mysql.cj.Driver");
//        }catch(ClassNotFoundException e){
//            e.printStackTrace();
//        }
//    }
//
//    private Connection getConnection() throws SQLException{
//        return DriverManager.getConnection(URL,USER,PASSWORD);
//    }
//
//
//    public void saveCompany(Company company){
//        String sql = "INSERT INTO company (companyId, companyname, ownerName) VALUES (?, ?, ?)";
//
//
//        try(Connection connection = getConnection();
//            PreparedStatement pstmt = connection.prepareStatement(sql))
//        {
//            pstmt.setInt(1, company.getCompanyId());
//            pstmt.setString(2, company.getCompanyName());
//            pstmt.setString(3, company.getOwnerName());
//            pstmt.executeUpdate();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public Company getCompany(int companyId){
//        String sql = "SELECT * FROM company WHERE companyId = ?";
//
//        try(Connection connection = getConnection();
//        PreparedStatement pstmt = connection.prepareStatement(sql))
//        {
//            pstmt.setInt(1,companyId);
//            try(ResultSet rs = pstmt.executeQuery()){
//                if(rs.next()){
//                    int id = rs.getInt("companyId");
//                    String companyName = rs.getString("companyName");
//                    String ownerName = rs.getString("ownerName");
//                    return new Company(id,companyName,ownerName);
//                }
//            }
//
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public void UpdateCompany(Company company){
//        String sql = "UPDATE company SET companyName = ?, ownerName = ? WHERE companyId = ?";
//        try(Connection connection = getConnection();
//            PreparedStatement pstmt = connection.prepareStatement(sql))
//        {
//            pstmt.setString(1,company.getCompanyName());
//            pstmt.setString(2, company.getOwnerName());
//            pstmt.setInt(3,company.getCompanyId());
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//
//    public void deleteCompany(int companyId){
//        String sql = "DELETE FROM company WHERE companyId = ?";
//        try(Connection connection = getConnection();
//        PreparedStatement pstmt = connection.prepareStatement(sql)){
//            pstmt.setInt(1,companyId);
//            pstmt.executeUpdate();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    public List<Company> getCompanies(){
//        List<Company> companies = new ArrayList<>();
//        String sql = "SELECT * FROM company ORDER BY companyId";
//        try(Connection connection = getConnection();
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery(sql)){
//            while (rs.next()){
//                int id = rs.getInt("companyId");
//                String companyName = rs.getString("companyName");
//                String ownerName = rs.getString("ownerName");
//                companies.add(new Company(id,companyName,ownerName));
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return companies;
//    }
//
//}
