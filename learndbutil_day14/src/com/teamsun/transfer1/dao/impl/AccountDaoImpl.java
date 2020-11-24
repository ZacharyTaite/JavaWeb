package com.teamsun.transfer1.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.teamsun.transfer1.dao.AccountDao;
import com.teamsun.transfer1.util.C3P0Util;

public class AccountDaoImpl implements AccountDao {

	public void updateAccount(String fromname, String toname, double money) throws Exception {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update account set money=money-? where name=?",money,fromname);
		qr.update("update account set money=money+? where name=?",money,toname);
	}

}
