package com.teamsun.dbutils.util;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class TestCRUD {
	@Test
	public void testInsert() throws SQLException{
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		//执行sql语句
		qr.update("insert into users(username,password,email,birthday) values(?,?,?,?)", "菜10","123","c10@163.com",new Date());
		
	}
	
	@Test
	public void testUpdate() throws SQLException{
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update users set username=?,password=? where id=?", "周杰杰","333",15);
	}
	
	
	@Test
	public void testDelete() throws SQLException{
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from users where id=?", 15);
	}
	
	@Test//批处理，只能执行相同的sql语句
	public void testBatch() throws SQLException{
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Object[][] params = new Object[10][];//高维代表执行多少次sql语句
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{"菜10"+i,"123","c10@163.com",new Date()};//给每次执行的sql语句中的？赋值
		}
		qr.batch("insert into users(username,password,email,birthday) values(?,?,?,?)", params );
		
	}
}
