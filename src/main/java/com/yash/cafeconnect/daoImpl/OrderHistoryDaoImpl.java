package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.OrderHistoryDao;
import com.yash.cafeconnect.entity.OrderHistory;
import java.sql.*;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;
/**
 * Implementation of OrderHistoryDao
 */
public class OrderHistoryDaoImpl implements OrderHistoryDao {
    private static final String URL = "jdbc:mysql://localhost:3306/cafe";
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
    public void saveOrderHistory(OrderHistory orderHistory) {
        String sql = "INSERT INTO order_history (orderId, userEmailId, totalAmount, orderTime) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderHistory.getOrderId());
            pstmt.setString(2, orderHistory.getUserEmailId());
            pstmt.setDouble(3, orderHistory.getTotalAmount());
            pstmt.setTimestamp(4, Timestamp.from(orderHistory.getOrderTime()));
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public OrderHistory getOrderHistory(int orderId) {
        String sql = "SELECT * FROM order_history WHERE orderId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    int oid = rs.getInt("orderId");
                    String userEmailId = rs.getString("userEmailId");
                    double totalAmount = rs.getDouble("totalAmount");
                    Instant orderTime = rs.getTimestamp("orderTime").toInstant();
                    return new OrderHistory(oid, userEmailId, totalAmount, orderTime);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateOrderHistory(OrderHistory orderHistory) {
        String sql = "UPDATE order_history SET userEmailId=?, totalAmount=?, orderTime=? WHERE orderId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, orderHistory.getUserEmailId());
            pstmt.setDouble(2, orderHistory.getTotalAmount());
            pstmt.setTimestamp(3, Timestamp.from(orderHistory.getOrderTime()));
            pstmt.setInt(4, orderHistory.getOrderId());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteOrderHistory(int orderId) {
        String sql = "DELETE FROM order_history WHERE orderId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List<OrderHistory> getOrderHistories() {
        List<OrderHistory> list = new ArrayList<>();
        String sql = "SELECT * FROM order_history ORDER BY orderId";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                int oid = rs.getInt("orderId");
                String userEmailId = rs.getString("userEmailId");
                double totalAmount = rs.getDouble("totalAmount");
                Instant orderTime = rs.getTimestamp("orderTime").toInstant();
                list.add(new OrderHistory(oid, userEmailId, totalAmount, orderTime));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
