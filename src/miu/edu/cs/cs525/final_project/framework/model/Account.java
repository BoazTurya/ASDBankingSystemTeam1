package miu.edu.cs.cs525.final_project.framework.model;

import java.util.ArrayList;
import java.util.Collection;

public class Account {
    private long accountNumber;
    private Customer customer;
    private IntrestStrategy intrestStrategy;
    private MinPaymentStartegy minPaymentStartegy;
    private AlertStaretegy alertStaretegy;
    private Collection<AccountEntry> transaction;
    private String accountType;


    public Account(long accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        transaction = new ArrayList<>();
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(amount, " effecting withdraw");
        transaction.add(entry);
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "deposit");
        transaction.add(entry);
    }

    public double getBalance() {
        double balance = 0;
        for (AccountEntry entry : transaction) {
            System.out.println("doing the collection");
            balance += entry.getAmount();
        }
        return balance;
    }
    public void setBalance(double amount) {
        deposit(amount);


    }

    //Getters & setters

    public MinPaymentStartegy getMinPaymentStartegy() {
        return minPaymentStartegy;
    }

    public void setMinPaymentStartegy(MinPaymentStartegy minPaymentStartegy) {
        this.minPaymentStartegy = minPaymentStartegy;
    }

    public AlertStaretegy getAlertStaretegy() {
        return alertStaretegy;
    }

    public void setAlertStaretegy(AlertStaretegy alertStaretegy) {
        this.alertStaretegy = alertStaretegy;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Collection<AccountEntry> getAccountsEntry() {
        return transaction;
    }

    public void addAccountEntry(AccountEntry accountEntry) {
        this.transaction.add(accountEntry);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTransaction(Collection<AccountEntry> transaction) {
        this.transaction = transaction;
    }

    public IntrestStrategy getIntrestStrategy() {
        return intrestStrategy;
    }

    public void setIntrestStrategy(IntrestStrategy intrestStrategy) {
        this.intrestStrategy = intrestStrategy;
    }

}
