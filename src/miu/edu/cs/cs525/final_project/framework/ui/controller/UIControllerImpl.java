package miu.edu.cs.cs525.final_project.framework.ui.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Person;
import miu.edu.cs.cs525.final_project.framework.service.AccountService;
import miu.edu.cs.cs525.final_project.test.bank.BankAccount;

public class UIControllerImpl implements UIController {
	private static UIControllerImpl instance;
	
	private AccountService accountService;
	Map<String,Account> accounts = new HashMap<>();

	private UIControllerImpl() {
	}
	public static UIControllerImpl getInstance(){
		if(instance==null) {
			instance = new UIControllerImpl();
		}		
	return instance;
	}
	@Override
	public void deposit(String number, Long amount) {
		//accountService.deposit(number, amount);
		System.out.println("Calling backend: Deposit"+amount+" Account "+number);
		accounts.get(number).deposit(amount);
	}
	@Override
	public Long withdraw(String number, Long amount) {
		System.out.println("Calling  backend:  Withdraw"+amount+" Account "+number);
		//return null;//accountService.withdraw(number, amount);
		accounts.get(number).withdraw(amount);
		return amount;
	}

	@Override
	public void addInterest() {
		
		System.out.println("Calling  backend:  Add interest to all");
		accounts.values().forEach(a->a.addInterest());;
		//accountService.calculateInterest();
	}
	@Override
	public Account loadAccount(String accountNo) {
		System.out.println("Calling  backend:  load account");
		return accounts.get(accountNo);
		//return accountService.getAccount(accountNo);
	}
	@Override
	public Account createBankAccount(String aNumber, String name, String street, String city, String state, String zip,LocalDate birthDate, String accountType) {
		System.out.println("Calling  backend:  create bank Account for "+name+ " "+city);
		Account acct = new BankAccount(aNumber, new Person( name, null, null,null),null,null,null);
		accounts.put(aNumber, acct);
		return acct;
		//accountService.createAccount(name,street,city,state,zip,aType)
	}
	@Override
	public Account createCreditAccount(String aNumber, String name, String street, String city, String state, String zip, String expiry, String accountType) {
		System.out.println("Calling  backend:  create credit Account for "+name+ " "+city);
		
		return null;
		//accountService.createAccount(name,street,city,state,zip,aType)
	}
	@Override
	public Account loadCreditAccount(String ccnumber) {
		System.out.println("Calling  backend: load credid account Account for "+ccnumber);
		// TODO Auto-generated method stub
		return null;
	}
}
