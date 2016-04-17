package com.vandanpatel.calendar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vandanpatel.calendar.dao.AccountDAO;
import com.vandanpatel.calendar.model.Account;

@Service("accountsService")
public class AccountsService {

	private AccountDAO accountsDAO;

	@Autowired
	public void setAccountsDAO(AccountDAO accountsDAO) {
		this.accountsDAO = accountsDAO;
	}

	public List<Account> getCurrent(){
		return accountsDAO.getAccounts();
	}
}
