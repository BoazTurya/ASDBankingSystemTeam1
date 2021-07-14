package miu.edu.cs.cs525.final_project.framework.service;


import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import miu.edu.cs.cs525.final_project.framework.observer.EmailSender;
import miu.edu.cs.cs525.final_project.framework.observer.Logger;
import miu.edu.cs.cs525.final_project.framework.observer.Subject;

import java.time.LocalDate;

public abstract class AccountServiceImpl extends Subject implements AccountService {
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    private CustomerService customerService;

    public AccountServiceImpl(AccountDAO accountDAO,CustomerDAO customerDAO,CustomerService customerService){
        this.accountDAO = accountDAO;
        this.customerDAO = customerDAO;
        this.customerService = customerService;

        this.addObserver(Logger.getInstance());
        this.addObserver(EmailSender.getInstance());
    }

    @Override
    public final Account createPersonalAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, LocalDate dob, String accountType) {
        Customer customer = customerService.createPerson(name,email,street,city,state,zip,dob);
        Account account = createAccount(accountNumber,customer, accountType);
        accountDAO.saveAccount(account);
        return account;}

    @Override
    public final Account createOrganizationAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, int numberOfEmployees, String accountType) {
        Customer customer = customerService.createOrganization(name,email,street,city,state,zip,numberOfEmployees);
        Account account = createAccount(accountNumber,customer, accountType);
        accountDAO.saveAccount(account);
        return account;}

    @Override
    public final Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    @Override
    public final void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        AccountEntry accountEntry = new AccountEntry(amount,"deposit");
        account.addAccountEntry(accountEntry);
        accountDAO.updateAccount(account);
        this.notifyAllObservers(account);
    }

    @Override
    public final void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        AccountEntry accountEntry = new AccountEntry(-amount,"withdraw");
        account.addAccountEntry(accountEntry);
        accountDAO.updateAccount(account);}


    public abstract Account createAccount(String accountNumber, Customer customer, String accountType);
}
