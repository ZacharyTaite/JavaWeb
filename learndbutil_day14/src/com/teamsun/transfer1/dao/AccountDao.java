package com.teamsun.transfer1.dao;

public interface AccountDao {
	/**
	 * ת��
	 * @param fromname ת���û�
	 * @param toname  ת���û�
	 * @param money  ת�˽��
	 */
	public void updateAccount(String fromname, String toname, double money)throws Exception;
}
