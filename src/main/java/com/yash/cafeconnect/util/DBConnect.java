package com.yash.cafeconnect.util;

import java.sql.*;



public class DBConnect {
    private static final String URL = "jdbc:mysql://localhost:3306/cafe_connect";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * Creates and returns a new database connection
     * @return Connection object or null if connection fails
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Failed to create connection: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates a Statement from the given connection
     * @param connection The database connection
     * @return Statement object or null if creation fails
     */
    public static Statement getStatement(Connection connection) {
        try {
            if (connection == null) {
                System.err.println("Connection is null, cannot create Statement");
                return null;
            }
            return connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Failed to create Statement: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Creates a PreparedStatement from the given connection and SQL
     * @param connection The database connection
     * @param sql The SQL query string
     * @return PreparedStatement object or null if creation fails
     */
    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
        try {
            if (connection == null) {
                System.err.println("Connection is null, cannot create PreparedStatement");
                return null;
            }
            if (sql == null || sql.trim().isEmpty()) {
                System.err.println("SQL query is null or empty");
                return null;
            }
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.err.println("Failed to create PreparedStatement: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Safely closes a Statement
     * @param statement The Statement to close
     */
    public static void closeStatement(Statement statement) {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing Statement: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Safely closes a PreparedStatement
     * @param preparedStatement The PreparedStatement to close
     */
    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing PreparedStatement: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Safely closes a Connection
     * @param connection The Connection to close
     */
    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing Connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
