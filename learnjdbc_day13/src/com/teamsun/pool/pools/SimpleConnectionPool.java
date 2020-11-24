package com.teamsun.pool.pools;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

import com.teamsun.pool.util.DBUtils;
//ģ�����ݿ����ӳأ������߱�ʵ�ʿ�������
public class SimpleConnectionPool {
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
	
	//�õ�һ������
	public static  Connection getConnectionFromPool(){
		Connection conn = null;
		if(pool.size()>0){
			conn =  pool.removeFirst();//�ӳ���ȡ��һ������
			return conn;
		}else{
			//�ȴ�
			//�´���һ������
			throw new RuntimeException("������æ������");
		}
		
	}
	//�ͷ���Դ
	public static  void release(Connection conn){
		pool.addLast(conn);
	}
}
