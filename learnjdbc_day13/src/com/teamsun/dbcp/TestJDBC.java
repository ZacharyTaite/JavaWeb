package com.teamsun.dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.teamsun.dbcp.DBCPUtil;

public class TestJDBC {
	@Test
	public void test1(){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBCPUtil.getConnection();
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
//			DBCPUtil.release(conn, ps, null);
		}
		
	}
}
