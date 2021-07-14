package miu.edu.cs.cs525.final_project.framework.ui.controller;

import java.time.LocalDate;

import miu.edu.cs.cs525.final_project.framework.model.Account;

public interface UIController {

	void deposit(String number, Long amount);
	Double withdraw(String number, Long amount);
	Account createBankAccount(String name, String street, String city, String state, String zip, LocalDate birthDate, String accountType);
	Account createCreditAccount(String name, String street, String city, String state, String zip, LocalDate expiry, String accountType);
	void addInterest();
	Account loadAccount(String accountNo);
}
