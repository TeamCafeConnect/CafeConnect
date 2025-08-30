package com.yash.cafeconnect.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    private static String url = "jdbc:mysql://localhost:3306/CafeConnect";
    private static String user = "root";
    private static String pass = "root";

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    private static Connection conn = null;

    public static Connection getConn(){
        try{
            if(conn == null) {
                conn = DriverManager.getConnection(url,user,pass);
            }
            if(conn.isClosed()){
                conn = DriverManager.getConnection(url,user,pass);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return  conn;

    }
}
