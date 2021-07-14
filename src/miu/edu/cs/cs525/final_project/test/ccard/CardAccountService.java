package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.service.AccountService;

import java.time.LocalDate;

public interface CardAccountService extends AccountService {
    CreditAccount createPersonalAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, LocalDate dob, String accountType, LocalDate expirationDate);
    CreditAccount createOrganizationAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, int numberOfEmployees, String accountType, LocalDate expirationDate);
    void charge(String accountNumber,double amount);
    void makePayment(String accountNumber, double amount);
}
