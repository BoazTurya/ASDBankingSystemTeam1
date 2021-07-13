package miu.edu.cs.cs525.final_project.framework.service;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.time.LocalDate;

public interface AccountService {
    Account createAccountTemplate(String accountNumber, String name, String email, String street, String city, String state, String zip, String accountType,String... args);
    Account getAccount(String accountNumber);
    void deposit(String accountNumber,double amount);
    void withdraw(String accountNumber,double amount);
    Account createAccount(String accountNumber, Customer customer,String accountType,String... args);
}
