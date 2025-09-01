package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.UserDao;
import com.yash.cafeconnect.entity.User;
import com.yash.cafeconnect.entity.enums.UserRoles;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Implementation of UserDao
 */
public class UserDaoImpl implements UserDao {
    private static final String URL = "jdbc:mysql://localhost:3306/cafeconnect";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    static {
        try {
            Class.forName("com.mysql.cj.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    public void saveUser(User user) {
        String sql = "INSERT INTO user (emailId, name, mobileNo, password, officeId, userRoles) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getEmailId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getMobileNo());
            pstmt.setString(4, user.getPassword());
            pstmt.setInt(5, user.getOfficeId());
            pstmt.setString(6, user.getUserRoles().name());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public User getUser(String emailId) {
        String sql = "SELECT * FROM user WHERE emailId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, emailId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    String eid = rs.getString("emailId");
                    String name = rs.getString("name");
                    String mobileNo = rs.getString("mobileNo");
                    String password = rs.getString("password");
                    int officeId = rs.getInt("officeId");
                    UserRoles roles = UserRoles.valueOf(rs.getString("userRoles"));
                    return new User(eid, name, mobileNo, password, officeId, roles);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateUser(User user) {
        String sql = "UPDATE user SET name=?, mobileNo=?, password=?, officeId=?, userRoles=? WHERE emailId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getMobileNo());
            pstmt.setString(3, user.getPassword());
            pstmt.setInt(4, user.getOfficeId());
            pstmt.setString(5, user.getUserRoles().name());
            pstmt.setString(6, user.getEmailId());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(String emailId) {
        String sql = "DELETE FROM user WHERE emailId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, emailId);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user ORDER BY emailId";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                String eid = rs.getString("emailId");
                String name = rs.getString("name");
                String mobileNo = rs.getString("mobileNo");
                String password = rs.getString("password");
                int officeId = rs.getInt("officeId");
                UserRoles roles = UserRoles.valueOf(rs.getString("userRoles"));
                users.add(new User(eid, name, mobileNo, password, officeId, roles));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
