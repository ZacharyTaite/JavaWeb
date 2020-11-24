package com.teamsun.pool.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.teamsun.pool.util.DBUtils;

public class MyDataSource implements DataSource{
	 //创建一个存放连接的池子
		private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
		
		static{
			try {
				for (int i = 0; i < 10; i++) {
					Connection conn = DBUtils.getConnection();
					pool.add(conn);
				}
			} catch (Exception e) {
				throw new ExceptionInInitializerError("初始化数据库连接失败，请检查配置文件是否正确！");
			}
		}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if(pool.size()>0){
			conn =  pool.removeFirst();//从池中取出一个连接
			MyConnection myConn = new MyConnection(conn,pool);//得到一个包装后的MyConnection对象
			return myConn;
		}else{
			//等待
			//新创建一个连接
			throw new RuntimeException("服务器忙。。。");
		}
	}
	
	
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	



}
