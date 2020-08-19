package com.teamsun.demo01.jdbcDemo;

import com.teamsun.demo01.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestCRUD {

    public static void main(String[] args) throws Exception {
        TestCRUD testCRUD = new TestCRUD();
        testCRUD.testDelete();
    }

    public void testSelect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "123456");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select password,email,id,username from user");
        List<User> list = new ArrayList<>();
        while (rs.next()){
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setEmail(rs.getString("email"));
            list.add(u);
        }
        //关闭资源
        rs.close();
        statement.close();
        connection.close();
        for (User user : list){
            System.out.println(user);
        }
    }

    public void testSelect1()throws Exception{
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //获取连接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "123456");
        //得到执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        //执行sql语句，并返回结果
        ResultSet rs = stmt.executeQuery("select password,email,id,username from user");
        List<User> list = new ArrayList<User>();

        rs.afterLast();
        rs.previous();
        //处理结果
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setUsername(rs.getString("username"));
        u.setPassword(rs.getString("password"));
        u.setEmail(rs.getString("email"));
        list.add(u);

        rs.close();
        stmt.close();
        conn.close();
        System.out.println(u);
    }

    public void testInsert()throws Exception{
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?user=root&password=123456");
        //得到执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        //执行sql语句，并返回结果
        int i = stmt.executeUpdate("INSERT INTO user VALUES(2,'tom','123','man','tom@163.com','18934321232','010','1',1,'0','2015-09-28')");
        if(i>0){
            System.out.println("success");
        }

        //关闭资源
        stmt.close();
        conn.close();
    }

    public void testUpdate() throws Exception{
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?user=root&password=123456");
        //得到执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        //执行sql语句，并返回结果
        int i = stmt.executeUpdate("UPDATE user SET USERNAME='jerry',PASSWORD='333',email='jerry@163.com' WHERE id=1");
        if(i>0){
            System.out.println("success"+" 修改了"+i+"行");
        }else{
            System.out.println("修改了"+i+"行");
        }

        //关闭资源
        stmt.close();
        conn.close();

    }

    public void testDelete() throws Exception{
        //加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?user=root&password=123456");
        //得到执行sql语句的对象Statement
        Statement stmt = conn.createStatement();
        //执行sql语句，并返回结果
        int i = stmt.executeUpdate("DELETE FROM user WHERE id=2");
        if(i>0){
            System.out.println("success");
        }

        //关闭资源
        stmt.close();
        conn.close();

    }
}
