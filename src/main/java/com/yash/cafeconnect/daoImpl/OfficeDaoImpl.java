//package com.yash.cafeconnect.daoImpl;
//import com.yash.cafeconnect.dao.OfficeDao;
//import com.yash.cafeconnect.entity.Order;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class OfficeDaoImpl implements OfficeDao {
//    public void saveOrder(Order order) {
//        String sql = "INSERT INTO order(orderId,userEmailId,cafeId,totalAmount,expectedDeliveryTimeInMinutes) VALUES(?,?,?,?,?)";
//        try(Connection connection = getConnection();
//            PreparedStatement pstmt = connection.prepareStatement(sql))
//        {
//            pstmt.setInt(1,order.getOrderId());
//            pstmt.setString(2, order.getUserEmailId());
//            pstmt.setString(3, order.getCafeId());
//            pstmt.setDouble(4, order.getTotalAmount());
//            pstmt.setDouble(5, order.getExpectedDeliveryTimeInMinutes());
//            pstmt.executeUpdate();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Order getOrder(int OrderId){
//        String sql = "SELECT * FROM order WHERE orderId = ?";
//        try(Connection connection = getConnection();
//        PreparedStatement pstmt = connection.prepareStatement(sql))
//        {
//            pstmt.setInt("orderId");
//            try(ResultSet rs = pstmt.executeQuery()){
//                if (rs.next()){
//                    rs.getInt("orderId"),
//      g              rs.getString("userEmailId"),
//                    rs.getString("cafeId"),
//                    rs.getDouble("totalAmount"),
//                    rs.getDouble("expectedDeliveryTimeInMinutes");
//                }
//            }
//        }
//    }
//}