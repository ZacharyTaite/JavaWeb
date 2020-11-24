package com.teamsun.pool.warper;

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
	 //����һ��������ӵĳ���
		private static LinkedList<Connection> pool = (LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>());
		
		static{
			try {
				for (int i = 0; i < 10; i++) {
					Connection conn = DBUtils.getConnection();
					pool.add(conn);
				}
			} catch (Exception e) {
				throw new ExceptionInInitializerError("��ʼ�����ݿ�����ʧ�ܣ����������ļ��Ƿ���ȷ��");
			}
		}
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		if(pool.size()>0){
			conn =  pool.removeFirst();//�ӳ���ȡ��һ������
			MyConnection myConn = new MyConnection(conn,pool);//�õ�һ����װ���MyConnection����
			return myConn;
		}else{
			//�ȴ�
			//�´���һ������
			throw new RuntimeException("������æ������");
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