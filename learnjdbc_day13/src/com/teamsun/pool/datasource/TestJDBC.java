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
			conn = ds.getConnection();//从池中取出一个连接 MyConnection
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();//该关就关闭，是否真的关了取决于 conn对象中怎么来的
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
