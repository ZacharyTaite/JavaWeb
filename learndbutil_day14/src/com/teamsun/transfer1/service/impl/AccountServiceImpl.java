package com.teamsun.transfer1.service.impl;

import com.teamsun.transfer1.dao.AccountDao;
import com.teamsun.transfer1.dao.impl.AccountDaoImpl;
import com.teamsun.transfer1.service.AccountService;

public class AccountServiceImpl implements AccountService {

	AccountDao ad = new AccountDaoImpl();
	public void transfer(String fromname, String toname, double money)
			throws Exception {
		ad.updateAccount(fromname, toname, money);
	}

}
