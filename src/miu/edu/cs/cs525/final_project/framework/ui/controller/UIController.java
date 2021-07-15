package miu.edu.cs.cs525.final_project.framework.ui.controller;

import java.time.LocalDate;

import miu.edu.cs.cs525.final_project.framework.model.Account;

public interface UIController {

	void deposit(String number, Long amount);
	Long withdraw(String number, Long amount);
	Account createBankAccount(String number, String name, String street, String city, String state, String zip, LocalDate birthDate, String accountType);
	Account createCreditAccount(String number, String name, String street, String city, String state, String zip, String expiry, String accountType);
	void addInterest();
	Account loadAccount(String accountNo);
	Account loadCreditAccount(String ccnumber);
}
