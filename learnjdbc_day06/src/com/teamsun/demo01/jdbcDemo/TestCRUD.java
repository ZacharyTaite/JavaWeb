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
        //�ر���Դ
        rs.close();
        statement.close();
        connection.close();
        for (User user : list){
            System.out.println(user);
        }
    }

    public void testSelect1()throws Exception{
        //��������
        Class.forName("com.mysql.jdbc.Driver");

        //��ȡ����Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "123456");
        //�õ�ִ��sql���Ķ���Statement
        Statement stmt = conn.createStatement();
        //ִ��sql��䣬�����ؽ��
        ResultSet rs = stmt.executeQuery("select password,email,id,username from user");
        List<User> list = new ArrayList<User>();

        rs.afterLast();
        rs.previous();
        //������
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
        //��������
        Class.forName("com.mysql.jdbc.Driver");
        //��ȡ����Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?user=root&password=123456");
        //�õ�ִ��sql���Ķ���Statement
        Statement stmt = conn.createStatement();
        //ִ��sql��䣬�����ؽ��
        int i = stmt.executeUpdate("INSERT INTO user VALUES(2,'tom','123','man','tom@163.com','18934321232','010','1',1,'0','2015-09-28')");
        if(i>0){
            System.out.println("success");
        }

        //�ر���Դ
        stmt.close();
        conn.close();
    }

    public void testUpdate() throws Exception{
        //��������
        Class.forName("com.mysql.jdbc.Driver");
        //��ȡ����Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?user=root&password=123456");
        //�õ�ִ��sql���Ķ���Statement
        Statement stmt = conn.createStatement();
        //ִ��sql��䣬�����ؽ��
        int i = stmt.executeUpdate("UPDATE user SET USERNAME='jerry',PASSWORD='333',email='jerry@163.com' WHERE id=1");
        if(i>0){
            System.out.println("success"+" �޸���"+i+"��");
        }else{
            System.out.println("�޸���"+i+"��");
        }

        //�ر���Դ
        stmt.close();
        conn.close();

    }

    public void testDelete() throws Exception{
        //��������
        Class.forName("com.mysql.jdbc.Driver");
        //��ȡ����Connection
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?user=root&password=123456");
        //�õ�ִ��sql���Ķ���Statement
        Statement stmt = conn.createStatement();
        //ִ��sql��䣬�����ؽ��
        int i = stmt.executeUpdate("DELETE FROM user WHERE id=2");
        if(i>0){
            System.out.println("success");
        }

        //�ر���Դ
        stmt.close();
        conn.close();

    }
}
