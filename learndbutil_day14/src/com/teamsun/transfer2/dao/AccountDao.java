package com.teamsun.transfer2.dao;

import com.teamsun.transfer2.domain.Account;

public interface AccountDao {
	/**
	 * ת��
	 * @param fromname ת���û�
	 * @param toname  ת���û�
	 * @param money  ת�˽��
	 */
	@Deprecated
	public void updateAccount(String fromname, String toname, double money)throws Exception;
	
	/**
	 * �����˻���Ϣ�޸Ľ��
	 * @param accout
	 */
	public void updateAccout(Account accout) throws Exception;
	
	/**
	 * �����û��������˻���Ϣ
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Account findAccountByName(String name)throws Exception;
}
