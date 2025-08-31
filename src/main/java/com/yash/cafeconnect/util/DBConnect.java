package com.yash.cafeconnect.util;

import java.sql.*;

public class DBConnect {
    private  static final String URL = "jdbc:mysql://localhost:3306/cafe_connect";

    /** Database username */
    private static final String USER = "root";

    /** Database password */
   private static final String PASSWORD = "root";

   private static  Connection con = null;





    /**
     * Opens and returns a database connection.

     */

    public Connection openConnection() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            if (con == null) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            if (con.isClosed()) {
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return con;
    }

    /**
     * Creates and returns a PreparedStatement for the given SQL string.

     */
    public PreparedStatement createPreparedStatement(String sql) {
        try {
            return openConnection().prepareStatement(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    /**
     * Closes the given PreparedStatement.
     */
    public void closePreparedStatement(PreparedStatement pstmt) {
        try {
            pstmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    /**
     * Executes a SQL query and returns a ResultSet.

     */
    public ResultSet createResultSet(Connection con,PreparedStatement pstmt,String query) {
        try {

            return openConnection().createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * Closes the given ResultSet.
     */
    public void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }

    /**
     * Closes the database connection.
     */
    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage());
        }
    }


}
