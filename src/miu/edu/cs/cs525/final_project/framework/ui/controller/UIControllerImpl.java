package miu.edu.cs.cs525.final_project.framework.ui.controller;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.service.AccountService;

public class UIControllerImpl implements UIController {
	private static UIControllerImpl instance;
	
	private AccountService accountService;

	private UIControllerImpl() {
	}
	public static UIControllerImpl getInstance(){
//		if(instance ==null) {
//			synchronized (instance) {
				if(instance==null) {
					instance = new UIControllerImpl();
				}
		
		return instance;
	}
	@Override
	public void deposit(String number, double amount) {
		//accountService.deposit(number, amount);
		System.out.println("Calling backend: Deposit"+amount+" Account "+number);
		
	}
	@Override
	public Double withdraw(String number, double amount) {
		System.out.println("Calling  backend:  Withdraw"+amount+" Account "+number);
		return null;//accountService.withdraw(number, amount);
	}
	@Override
	public Account createAccount(String name, String street, String city, String state, String zip, String aType) {
		System.out.println("Calling  backend:  create Account for "+name+ " "+city);
		return null;
		//accountService.createAccount(name,street,city,state,zip,aType)
	}
	@Override
	public void addInterest() {
		//accountService.addInterest();
		System.out.println("Calling  backend:  Add interest to all");
	}
	@Override
	public Account loadAccount(String accountNo) {
		System.out.println("Calling  backend:  load account");
		return null;
		//accountService.getAccount(String accountNo)
	}
}
