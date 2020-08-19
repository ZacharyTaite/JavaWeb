package com.teamsun.crud.service;

import com.teamsun.crud.entity.User;
import com.teamsun.crud.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoLogin {

    public User findUser(String name,String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        User u = null;
        try {
            connection = DBUtils.getConnection();
            String sql = "SELECT * FROM user WHERE USERNAME=? AND PASSWORD=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                u = new User();
                u.setId(rs.getInt(1));
                u.setUsername(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.closeAll(rs,preparedStatement,connection);
        }
        return u;
    }
}
