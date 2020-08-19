package com.teamsun.crud.util;

import javax.annotation.Resource;
import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {
        ResourceBundle dbinfo = ResourceBundle.getBundle("dbinfo");
        driverClass = dbinfo.getString("driverClass");
        url = dbinfo.getString("url");
        username = dbinfo.getString("username");
        password = dbinfo.getString("password");
        try {
            Class.forName(driverClass);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void closeAll(ResultSet rs, Statement stmt,Connection conn){
        //¹Ø±Õ×ÊÔ´
        if(rs!=null){
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(stmt!=null){
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
