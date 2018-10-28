package com.nana.bankapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
			currentSession.save(accountEntity);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			saveFlag = false;
		}
		
		return saveFlag;
	}

}
