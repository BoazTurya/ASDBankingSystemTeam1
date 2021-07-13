package miu.edu.cs.cs525.final_project.framework.model;

import miu.edu.cs.cs525.final_project.framework.strategy.AlertStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private InterestStrategy interestStrategy;
    private AlertStrategy alertStrategy;
    private PaymentStrategy paymentStrategy;
    private Collection<AccountEntry> accountEntries;

    public Account(String accountNumber, Customer customer, InterestStrategy accountStrategy,AlertStrategy alertStrategy,PaymentStrategy paymentStrategy) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.interestStrategy = accountStrategy;
        this.alertStrategy = alertStrategy;
        this.paymentStrategy = paymentStrategy;
        accountEntries = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
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

    public double getBalance(){
        return 0;
    }
}
