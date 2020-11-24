package com.teamsun.pool.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

public class TestJDBC {
	@Test
	public void test1(){
		
		Connection conn = null;
		PreparedStatement ps = null;
		DataSource ds = new MyDataSource();
		try {
			conn = ds.getConnection();//�ӳ���ȡ��һ������ MyConnection
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();//�ùؾ͹رգ��Ƿ���Ĺ���ȡ���� conn��������ô����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
