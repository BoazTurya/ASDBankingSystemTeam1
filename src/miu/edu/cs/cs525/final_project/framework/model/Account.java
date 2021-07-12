package miu.edu.cs.cs525.final_project.framework.model;

import miu.edu.cs.cs525.final_project.framework.IntrestStrategy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private IntrestStrategy intrestStrategy;
    private Collection<AccountEntry> accountEntries;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        accountEntries = new ArrayList<>();
    }


    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(amount, " effecting withdraw");
        accountEntries.add(entry);
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit");
        accountEntries.add(entry);
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : accountEntries) {
            balance += entry.getAmount();
        }
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Collection<AccountEntry> getAccountEntry() {
        return accountEntries;
    }

    public void addAccountEntry(AccountEntry accountEntry) {
        this.accountEntries.add(accountEntry);
    }


}
