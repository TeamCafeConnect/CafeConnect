package com.yash.cafeconnect.daoImpl;

import com.yash.cafeconnect.dao.TransactionDao;
import com.yash.cafeconnect.entity.Transaction;
import com.yash.cafeconnect.entity.enums.TransactionStatus;
import java.sql.*;
import java.time.Instant;
import java.util.List;
import java.util.ArrayList;
/**
 * Implementation of TransactionDao
 */
public class TransactionDaoImpl implements TransactionDao {
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
    public void saveTransaction(Transaction transaction) {
        String sql = "INSERT INTO transaction (transactionId, amount, paymentMethod, transactionStatus, timeStamp, userEmailId, itemId, orderId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, transaction.getTransactionId());
            pstmt.setDouble(2, transaction.getAmount());
            pstmt.setString(3, transaction.getPaymentMethod());
            pstmt.setString(4, transaction.getTransactionStatus().name());
            pstmt.setTimestamp(5, Timestamp.from(transaction.getTimeStamp()));
            pstmt.setString(6, transaction.getUserEmailId());
            pstmt.setInt(7, transaction.getItemId());
            pstmt.setInt(8, transaction.getOrderId());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public Transaction getTransaction(int transactionId) {
        String sql = "SELECT * FROM transaction WHERE transactionId = ?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, transactionId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    int tid = rs.getInt("transactionId");
                    double amount = rs.getDouble("amount");
                    String paymentMethod = rs.getString("paymentMethod");
                    TransactionStatus status = TransactionStatus.valueOf(rs.getString("transactionStatus"));
                    Instant timeStamp = rs.getTimestamp("timeStamp").toInstant();
                    String userEmailId = rs.getString("userEmailId");
                    int itemId = rs.getInt("itemId");
                    int orderId = rs.getInt("orderId");
                    return new Transaction(tid, amount, paymentMethod, status, timeStamp, userEmailId, itemId, orderId);
                }
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE transaction SET amount=?, paymentMethod=?, transactionStatus=?, timeStamp=?, userEmailId=?, itemId=?, orderId=? WHERE transactionId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, transaction.getAmount());
            pstmt.setString(2, transaction.getPaymentMethod());
            pstmt.setString(3, transaction.getTransactionStatus().name());
            pstmt.setTimestamp(4, Timestamp.from(transaction.getTimeStamp()));
            pstmt.setString(5, transaction.getUserEmailId());
            pstmt.setInt(6, transaction.getItemId());
            pstmt.setInt(7, transaction.getOrderId());
            pstmt.setInt(8, transaction.getTransactionId());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteTransaction(int transactionId) {
        String sql = "DELETE FROM transaction WHERE transactionId=?";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, transactionId);
            pstmt.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transaction ORDER BY transactionId";
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                int tid = rs.getInt("transactionId");
                double amount = rs.getDouble("amount");
                String paymentMethod = rs.getString("paymentMethod");
                TransactionStatus status = TransactionStatus.valueOf(rs.getString("transactionStatus"));
                Instant timeStamp = rs.getTimestamp("timeStamp").toInstant();
                String userEmailId = rs.getString("userEmailId");
                int itemId = rs.getInt("itemId");
                int orderId = rs.getInt("orderId");
                transactions.add(new Transaction(tid, amount, paymentMethod, status, timeStamp, userEmailId, itemId, orderId));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
