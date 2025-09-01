package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.FeedbackDao;
import com.yash.cafeconnect.entity.Feedback;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

/**
 * Implementation of FeedbackDao
 */

public class FeedbackDaoImpl implements FeedbackDao {
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
    public void saveFeedback(Feedback feedback) {
        String sql = "INSERT INTO feedback (feedbackId, userEmailId, content, date, itemId, orderId, rating) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, feedback.getFeedbackId());
            pstmt.setString(2, feedback.getUserEmailId());
            pstmt.setString(3, feedback.getContent());
            pstmt.setTimestamp(4, new Timestamp(feedback.getDate().getTime()));
            pstmt.setInt(5, feedback.getItemId());
            pstmt.setInt(6, feedback.getOrderId());
            pstmt.setInt(7, feedback.getRating());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public Feedback getFeedback(int feedbackId) {
        String sql = "SELECT * FROM feedback WHERE feedbackId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, feedbackId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    feedbackId = rs.getInt("feedbackId");
                    String userEmailId = rs.getString("userEmailId");
                    String content = rs.getString("content");
                    Date date = new Date(rs.getTimestamp("date").getTime());
                    int itemId = rs.getInt("itemId");
                    int orderId = rs.getInt("orderId");
                    int rating = rs.getInt("rating");
                    return new Feedback(feedbackId, userEmailId, content, date, itemId, orderId, rating);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateFeedback(Feedback feedback) {
        String sql = "UPDATE feedback SET userEmailId=?, content=?, date=?, itemId=?, orderId=?, rating=? WHERE feedbackId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, feedback.getUserEmailId());
            pstmt.setString(2, feedback.getContent());
            pstmt.setTimestamp(3, new Timestamp(feedback.getDate().getTime()));
            pstmt.setInt(4, feedback.getItemId());
            pstmt.setInt(5, feedback.getOrderId());
            pstmt.setInt(6, feedback.getRating());
            pstmt.setInt(7, feedback.getFeedbackId());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteFeedback(int feedbackId) {
        String sql = "DELETE FROM feedback WHERE feedbackId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, feedbackId);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Feedback> getFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        String sql = "SELECT * FROM feedback ORDER BY feedbackId";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                int feedbackId = rs.getInt("feedbackId");
                String userEmailId = rs.getString("userEmailId");
                String content = rs.getString("content");
                Date date = new Date(rs.getTimestamp("date").getTime());
                int itemId = rs.getInt("itemId");
                int orderId = rs.getInt("orderId");
                int rating = rs.getInt("rating");
                feedbacks.add(new Feedback(feedbackId, userEmailId, content, date, itemId, orderId, rating));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return feedbacks;
    }
}
