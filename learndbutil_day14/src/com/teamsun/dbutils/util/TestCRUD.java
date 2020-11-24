package com.teamsun.dbutils.util;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

public class TestCRUD {
	@Test
	public void testInsert() throws SQLException{
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		//ִ��sql���
		qr.update("insert into users(username,password,email,birthday) values(?,?,?,?)", "��10","123","c10@163.com",new Date());
		
	}
	
	@Test
	public void testUpdate() throws SQLException{
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update users set username=?,password=? where id=?", "�ܽܽ�","333",15);
	}
	
	
	@Test
	public void testDelete() throws SQLException{
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from users where id=?", 15);
	}
	
	@Test//������ֻ��ִ����ͬ��sql���
	public void testBatch() throws SQLException{
		//����һ��QueryRunner����
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		
		Object[][] params = new Object[10][];//��ά����ִ�ж��ٴ�sql���
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{"��10"+i,"123","c10@163.com",new Date()};//��ÿ��ִ�е�sql����еģ���ֵ
		}
		qr.batch("insert into users(username,password,email,birthday) values(?,?,?,?)", params );
		
	}
}
