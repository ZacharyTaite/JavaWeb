package com.teamsun.jdbcDemo;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Demo2 {

    public static void main(String[] args) throws Exception {
        Demo2 demo2 = new Demo2();
        demo2.test3();
    }

    public void test1() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "123456");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select id,username,password,email from user");
        //处理结果
        while(rs.next()){
            System.out.println(rs.getObject(1));
            System.out.println(rs.getObject(2));
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(4));
            System.out.println("-----------------");
        }
        //关闭资源
        rs.close();
        statement.close();
        connection.close();
    }

    public void test2()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Properties ps = new Properties();
        ps.setProperty("user","root");
        ps.setProperty("password","123456");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore",ps);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select id,username,password,email from user");
        //处理结果
        while(rs.next()){
            System.out.println(rs.getObject(1));
            System.out.println(rs.getObject(2));
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(4));
            System.out.println("-----------------");
        }
        //关闭资源
        rs.close();
        statement.close();
        connection.close();
    }

    public void test3()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?user=root&password=123456");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select id,username,password,email from user");
        //处理结果
        while(rs.next()){
            System.out.println(rs.getObject(1));
            System.out.println(rs.getObject(2));
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(4));
            System.out.println("-----------------");
        }
        //关闭资源
        rs.close();
        statement.close();
        connection.close();
    }
}
