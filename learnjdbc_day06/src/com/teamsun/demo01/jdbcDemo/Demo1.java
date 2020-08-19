package com.teamsun.demo01.jdbcDemo;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class Demo1 {

    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "123456");
        Statement statement = connection.createStatement();
        ResultSet rs= statement.executeQuery("select password,email,id,username from user");
        while (rs.next()){
            System.out.println(rs.getObject("password"));
            System.out.println(rs.getObject("id"));
            System.out.println(rs.getObject("username"));
            System.out.println(rs.getObject("email"));
            System.out.println("-----------------");
        }
        //¹Ø±Õ×ÊÔ´
        rs.close();
        statement.close();
        connection.close();
    }
}
