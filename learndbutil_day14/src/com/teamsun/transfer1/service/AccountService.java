package com.teamsun.transfer1.service;

public interface AccountService {
	/**
	 * ת��
	 * @param fromname ת���û�
	 * @param toname  ת���û�
	 * @param money  ת�˽��
	 */
	public void transfer(String fromname, String toname, double money)throws Exception;
}
