package com.nana.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nana.bankapp.model.Account;
import com.nana.bankapp.services.AccountService;

@Controller
@RequestMapping(value = "/account")
public class AccountRESTController {

	@Autowired
	private AccountService accountService;

	/*@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Account getAccount(@PathVariable("id") Integer accountNo) {
		System.out.println("Requested Account Number: " + accountNo);
		Account account = accountService.getAccount(accountNo);
		return account;
	}*/

	/*@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Account> getAccounts(@RequestBody Account accnt) {
		System.out.println("Requested Account Number: " + accnt.getAccountNo());
		Account account = accountService.getAccount(accnt.getAccountNo());
		if (account == null) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}*/

	/*@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Account> postAccount(@RequestParam(value = "accountNo", required = false)  Integer accountNo) {
		System.out.println("Requested Account Number: " + accountNo);
		Account account = accountService.getAccount(accountNo);

		if (account == null) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public ResponseEntity<Account> getAccounts(@PathVariable("id") Integer accountNo) {
		System.out.println("Masuk sini pak eko..");
		System.out.println("Requested Account Number: " + accountNo);
		Account account = accountService.getAccount(accountNo);
		if (account == null) {
			return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
}
