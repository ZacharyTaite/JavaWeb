package com.teamsun.pool.pools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSource ds = new MyDataSource();
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ds.getConnection();//com.mysql.jdbc.Connection
			ps = conn.prepareStatement("..");
			
//			...
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();//²»Òª¹Ø
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
