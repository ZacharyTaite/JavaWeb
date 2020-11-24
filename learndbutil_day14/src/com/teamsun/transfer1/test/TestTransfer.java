package com.teamsun.transfer1.test;

import com.teamsun.transfer1.service.AccountService;
import com.teamsun.transfer1.service.impl.AccountServiceImpl;

public class TestTransfer {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		AccountService as = new AccountServiceImpl();
		as.transfer("aaa", "bbb", 100);
	}

}
