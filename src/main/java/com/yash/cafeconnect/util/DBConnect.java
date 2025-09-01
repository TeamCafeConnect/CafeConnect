package com.yash.cafeconnect.util;

import java.sql.*;

public class DBConnect {
    private  static final String URL = "jdbc:mysql://localhost:3306/cafe_connect";

    /** Database username */
    private static final String USER = "cafe_manager";

    /** Database password */
   private static final String PASSWORD = "cafe@2025";

   private static  Connection con = null;


}