package com.nana.bankapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nana.bankapp.entity.AccountEntity;
import com.nana.bankapp.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveAccount(Account account) {
		// TODO Auto-generated method stub
		boolean saveFlag = true;

		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccNo(account.getAccountNo());
		accountEntity.setAccHolderName(account.getAccountHolderName());
		accountEntity.setBalance(account.getBalance());
		accountEntity.setAccountType(account.getAccountType());
		accountEntity.setDateOfBirth(account.getDateOfBirth());
		accountEntity.setPsCode(account.getPsCode());

		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.saveOrUpdate(accountEntity);
//			currentSession.save(accountEntity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			saveFlag = false;
		}
		
		return saveFlag;
	}

	@Override
	public List<Account> getAccounts() {
		List<Account> list = new ArrayList<Account>();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			Query <AccountEntity> query = session.createQuery("FROM AccountEntity", AccountEntity.class);
			List<AccountEntity> accounts = query.getResultList();
			
			for (int i = 0; i < accounts.size(); i++) {
				AccountEntity accountEntity = (AccountEntity) accounts.get(i);
				Account account = new Account();
				account.setAccountNo(accountEntity.getAccNo());
				account.setAccountHolderName(accountEntity.getAccHolderName());
				account.setBalance(accountEntity.getBalance());
				account.setAccountType(accountEntity.getAccountType());
				account.setDateOfBirth(accountEntity.getDateOfBirth());
				account.setPsCode(accountEntity.getPsCode());
				list.add(account);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Account getAccount(Integer accountNo) {
		Account account = new Account();
		
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class, accountNo);
			account.setAccountNo(accountEntity.getAccNo());
			account.setAccountHolderName(accountEntity.getAccHolderName());
			account.setBalance(accountEntity.getBalance());
			account.setAccountType(accountEntity.getAccountType());
			account.setDateOfBirth(accountEntity.getDateOfBirth());
			account.setPsCode(accountEntity.getPsCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return account;
	}

	@Override
	public boolean deleteAccount(int accountNo) {
		// TODO Auto-generated method stub
		boolean deleteFlag = true;
		
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class, accountNo);
			session.delete(accountEntity);
		} catch (Exception e) {
			e.printStackTrace();
			deleteFlag = false;
		}
		
		return deleteFlag;
	}

}
