package com.nana.bankapp.services;

import java.util.List;

import com.nana.bankapp.model.Account;

public interface AccountService {
	public boolean saveAccount(Account account);
	public List<Account> getAccounts();
	public Account getAccount(Integer integer);
	public boolean deleteAccount(int accountNo);
}
