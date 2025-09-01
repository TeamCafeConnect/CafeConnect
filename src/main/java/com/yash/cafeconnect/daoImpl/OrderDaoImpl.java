package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.OrderDao;
import com.yash.cafeconnect.entity.Order;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
/**
 * Implementation of OrderDao
 */
public class OrderDaoImpl implements OrderDao {
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
    public void saveOrder(Order order) {
        String sql = "INSERT INTO orders (orderId, userEmailId, cafeId, totalAmount, expectedDeliveryTimeInMinutes) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, order.getOrderId());
            pstmt.setString(2, order.getUserEmailId());
            pstmt.setString(3, order.getCafeId());
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setDouble(5, order.getExpectedDeliveryTimeInMinutes());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public Order getOrder(int orderId) {
        String sql = "SELECT * FROM orders WHERE orderId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    int oid = rs.getInt("orderId");
                    String userEmailId = rs.getString("userEmailId");
                    String cafeId = rs.getString("cafeId");
                    double totalAmount = rs.getDouble("totalAmount");
                    double expectedDeliveryTimeInMinutes = rs.getDouble("expectedDeliveryTimeInMinutes");
                    return new Order(oid, userEmailId, cafeId, totalAmount, expectedDeliveryTimeInMinutes);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateOrder(Order order) {
        String sql = "UPDATE orders SET userEmailId=?, cafeId=?, totalAmount=?, expectedDeliveryTimeInMinutes=? WHERE orderId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, order.getUserEmailId());
            pstmt.setString(2, order.getCafeId());
            pstmt.setDouble(3, order.getTotalAmount());
            pstmt.setDouble(4, order.getExpectedDeliveryTimeInMinutes());
            pstmt.setInt(5, order.getOrderId());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteOrder(int orderId) {
        String sql = "DELETE FROM orders WHERE orderId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders ORDER BY orderId";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                int oid = rs.getInt("orderId");
                String userEmailId = rs.getString("userEmailId");
                String cafeId = rs.getString("cafeId");
                double totalAmount = rs.getDouble("totalAmount");
                double expectedDeliveryTimeInMinutes = rs.getDouble("expectedDeliveryTimeInMinutes");
                orders.add(new Order(oid, userEmailId, cafeId, totalAmount, expectedDeliveryTimeInMinutes));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
