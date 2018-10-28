package com.nana.bankapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nana.bankapp.model.Account;
import com.nana.bankapp.services.AccountService;

@Controller
public class AccountContoller {

	@Autowired
	AccountService accountService;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}
	
	@RequestMapping("/")
	public String showHomePage() {
		return "index";
	}

	@RequestMapping("/new")
	public String newAccount(Model model) {
		model.addAttribute("account", new Account());
		return "account-form";
	}

	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";
	}
	
	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result) {
		if (result.hasErrors() ) {
			return "account-form";
		} else {
			accountService.saveAccount(account);
			return "redirect:/list";
		}		
	}
	
	@GetMapping("/list")
	public String listAccounts(Model model) {
		List<Account> accounts = accountService.getAccounts();
		model.addAttribute("accounts", accounts);
		return "listAccounts";
	}
	
	@GetMapping("/edit")
	public String updateAccount(@RequestParam("accountNo") int accountNo, Model model) {
		Account account = accountService.getAccount(new Integer(accountNo));
		model.addAttribute("account", account);
		return "account-form";
	}
	
	
	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("accountNo") int accountNo, Model model) {
		accountService.deleteAccount(accountNo);
		return "redirect:/list";
	}
	
	/*  @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
		public String saveAccount(Model model, HttpServletRequest request) {
		String acNo = request.getParameter("accountNo");
		String customerName = request.getParameter("accountHolderName");
		String balance = request.getParameter("balance");

		/* model.addAttribute("accountNo", acNo);
		model.addAttribute("accountHolderName", customerName);
		model.addAttribute("balance", balance); 
		
		Account account = new Account();
		account.setAccountNo(Integer.parseInt(acNo));
		account.setAccountHolderName(customerName);
		account.setBalance(Integer.parseInt(balance));

		model.addAttribute("account",account);
		
		return "showAccount"; 
	} */

}
