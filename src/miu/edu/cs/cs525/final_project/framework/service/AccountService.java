package miu.edu.cs.cs525.final_project.framework.service;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.time.LocalDate;
import java.util.Collection;

public interface AccountService {
    Account createPersonalAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, LocalDate dob, String accountType);
    Account createOrganizationAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, int numberOfEmployees, String accountType);
    Account getAccount(String accountNumber);
    double getBalance(String accountNumber);
    void deposit(String accountNumber,double amount);
    void withdraw(String accountNumber,double amount);
    void calculateInterest();
    Collection<Account> getAllAccounts();
}
