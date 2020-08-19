package com.teamsun.crud;

import com.teamsun.crud.entity.User;
import com.teamsun.crud.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestCRUD {
    public static void main(String[] args) {
        TestCRUD testCRUD = new TestCRUD();
        testCRUD.testDelete();
    }

    public void testSelect(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            connection = DBUtils.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from user");
            List<User> list = new ArrayList<>();
            while (rs.next()){
                User u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                list.add(u);
            }
            for (User user : list) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,statement,connection);
        }
    }

    public void testInsert(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtils.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "tom");
            preparedStatement.setString(3, "333");
            preparedStatement.setString(4, "tom@163.com");
            preparedStatement.setString(5, "2015-09-11");
            int i = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(null,preparedStatement,connection);
        }
    }

    public void testUpdate(){
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBUtils.getConnection();
            stmt = conn.prepareStatement("UPDATE user SET USERNAME=?,PASSWORD=?,email=? WHERE id=?");
            stmt.setString(1, "jerry123");
            stmt.setString(2, "123");
            stmt.setString(3, "jerry@qq.com");
            stmt.setInt(4, 1);

            int i = stmt.executeUpdate();
            if(i>0){
                System.out.println("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeAll(null, stmt, conn);
        }
    }

    public void testDelete(){
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            int i = stmt.executeUpdate("DELETE FROM user WHERE id=2");
            if(i>0){
                System.out.println("success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBUtils.closeAll(null, stmt, conn);
        }
    }
}
