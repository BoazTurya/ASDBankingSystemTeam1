package miu.edu.cs.cs525.final_project.framework.ui.controller;

import miu.edu.cs.cs525.final_project.framework.service.AccountService;

public class UIControllerImpl implements UIController {
	private static UIControllerImpl instance;
	
	private AccountService accountService;

	private UIControllerImpl() {
		// TODO Auto-generated constructor stub
	}
	public static UIControllerImpl getInstance(){
		if(instance ==null) {
			synchronized (instance) {
				if(instance==null) {
					instance = new UIControllerImpl();
				}
			}
		}
		return instance;
	}
	@Override
	public void deposit(String number, double amount) {
		// accountService.deposit(number, amount);
		
	}
	@Override
	public Double withdraw(String number, double amount) {
		return null;//accountService.withdraw(number, amount);
	}
	@Override
	public void createAccount(String name, String street, String city, String state, String zip, String aType) {
		//accountService.createAccount(name,street,city,state,zip,aType)
	}
	@Override
	public void addInterest() {
		//accountService.addInterest();
		
	}

	
	
	
	
	

}
