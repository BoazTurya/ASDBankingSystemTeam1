package miu.edu.cs.cs525.final_project.framework.ui.controller;

import miu.edu.cs.cs525.final_project.framework.model.Account;

public interface UIController {

	void deposit(String number, double amount);
	Double withdraw(String number, double amount);
	Account createAccount(String name, String street, String city, String state, String zip, String accountType);
	void addInterest();
	Account loadAccount(String accountNo);
}
