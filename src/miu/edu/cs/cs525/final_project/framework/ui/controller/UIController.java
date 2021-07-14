package miu.edu.cs.cs525.final_project.framework.ui.controller;

public interface UIController {
	void deposit(String number, double amount);
	double withdraw(String number, double amount);
	void createAccount(String name, String street, String city, String state, String zip);
	void addInterest();
}
