package com.nana.bankapp.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.nana.bankapp.validation.PSCode;

public class Account {

	@NotNull(message = "Account No can't be blank")
	private Integer accountNo;

	@NotNull(message = "Account Holder Name can't be blank")
	@Size(min = 2, max = 50, message = "Invalid length for Account Holder Name")
	@Pattern(regexp = "[A-Za-z(\\s)]+", message = "Invalid Account Holder Name")
	private String accountHolderName;

	@NotNull(message = "Balance amount is required")
	@Min(value = 5000, message = "Minimum balance must not be less than 5000")
	private Integer balance;

	@NotNull(message = "Account Type can't be null")
	private String accountType;

	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull(message = "Date of birth can't be null")
	@Past(message = "Account can't be created for a person not born")
	private Date dateOfBirth;

	@NotNull(message = "Security code required")
	@PSCode(value = "PSUSA", message = "Security code should start with PSUSA")
	private String psCode;

	public Account() {
		accountNo = 0;
		accountHolderName = "";
		balance = 0;
	}

	public Account(Integer accountNo, String accountHolderName, Integer balance) {
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

}
