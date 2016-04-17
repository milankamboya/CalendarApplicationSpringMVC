package com.vandanpatel.calendar.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vandanpatel.calendar.model.Account;
import com.vandanpatel.calendar.service.AccountsService;

@Controller
public class AccountController {

	private AccountsService accountsService;
	
	@Autowired
	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@RequestMapping("/")
	public String showHome(Model model){
		
		List<Account> accounts = accountsService.getCurrent();
		
		model.addAttribute("accounts", accounts);
		
		return "index";
	}
}
