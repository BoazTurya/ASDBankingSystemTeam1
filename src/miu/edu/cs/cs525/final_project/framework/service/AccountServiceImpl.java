package miu.edu.cs.cs525.final_project.framework.service;


import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.time.LocalDate;

public abstract class AccountServiceImpl implements AccountService{
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    private CustomerService customerService;

    public AccountServiceImpl(AccountDAO accountDAO,CustomerDAO customerDAO,CustomerService customerService){
        this.accountDAO = accountDAO;
        this.customerDAO = customerDAO;
        this.customerService = customerService;
    }

    @Override
    public final Account createAccountTemplate(String accountNumber, String name, String email,String street, String city, String state, String zip, String accountType,String... args) {
        Customer customer = customerService.createCustomer(name,email,street,city,state,zip);
        Account account = createAccount(accountNumber,customer, accountType,args);
        accountDAO.saveAccount(account);
        return account;
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        AccountEntry accountEntry = new AccountEntry(amount,"deposit");
        account.addAccountEntry(accountEntry);
        accountDAO.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        AccountEntry accountEntry = new AccountEntry(-amount,"withdraw");
        account.addAccountEntry(accountEntry);
        accountDAO.updateAccount(account);
    }

    public abstract Account createAccount(String accountNumber, Customer customer,String accountType,String... args);
}
