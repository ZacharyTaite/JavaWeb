package com.teamsun.transfer2.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.teamsun.transfer2.dao.AccountDao;
import com.teamsun.transfer2.dao.impl.AccountDaoImpl;
import com.teamsun.transfer2.domain.Account;
import com.teamsun.transfer2.service.AccountService;
import com.teamsun.transfer2.util.C3P0Util;

public class AccountServiceImpl implements AccountService {

	public void transfer(String fromname, String toname, double money) {
	//	ad.updateAccount(fromname, toname, money);
		Connection conn = C3P0Util.getConnection();
		AccountDao ad = new AccountDaoImpl(conn);
		
		try {
			conn.setAutoCommit(false);//begin
			//�ֱ�õ�ת����ת���˻�����
			Account fromAccount = ad.findAccountByName(fromname);
			Account toAccount = ad.findAccountByName(toname);
			
			//�޸��˻����ԵĽ��
			fromAccount.setMoney(fromAccount.getMoney()-money);
			toAccount.setMoney(toAccount.getMoney()+money);
			
			//���ת�˲���
			ad.updateAccout(fromAccount);
//			int i = 10/0;
			ad.updateAccout(toAccount);
			
			conn.commit();//�ύ����
		} catch (Exception e) {
			try {
				conn.rollback();//�ع�����
			} catch (SQLException e1) {
				e1.printStackTrace();
			} 
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}//�ر�
		}
	}

}
