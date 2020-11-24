package com.teamsun.transfer2.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.teamsun.transfer2.dao.AccountDao;
import com.teamsun.transfer2.domain.Account;
import com.teamsun.transfer2.util.C3P0Util;

public class AccountDaoImpl implements AccountDao {

	private Connection conn;

	public AccountDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public void updateAccount(String fromname, String toname, double money) throws Exception {
		//创建一个QueryRunner对象
		QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
		qr.update("update account set money=money-? where name=?",money,fromname);
		qr.update("update account set money=money+? where name=?",money,toname);
	}

	public void updateAccout(Account account) throws Exception {
		QueryRunner qr = new QueryRunner();
		qr.update(conn,"update account set money=? where name=?",account.getMoney(),account.getName());
	}

	public Account findAccountByName(String name) throws Exception {
		QueryRunner qr = new QueryRunner();
		return qr.query(conn,"select * from account where name=?", new BeanHandler<Account>(Account.class),name);
	}

}
