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

    public Collection<AccountEntry> getAccountEntries() {
        return accountEntries;
    }
    public void addAccountEntry(AccountEntry accountEntry) {
        this.accountEntries.add(accountEntry);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public InterestStrategy getInterestStrategy() {
        return interestStrategy;
    }

    public void setInterestStrategy(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    public AlertStrategy getAlertStrategy() {
        return alertStrategy;
    }

    public void setAlertStrategy(AlertStrategy alertStrategy) {
        this.alertStrategy = alertStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public abstract double getBalance();

    public double totalDeposit(){
        return getAccountEntries().stream().filter(accountEntry -> accountEntry.getDescription() == "deposit").mapToDouble(entry -> entry.getAmount()).sum();
    };
    public double totalWithdraw(){
        return getAccountEntries().stream().filter(accountEntry -> accountEntry.getDescription() == "withdraw").mapToDouble(entry -> entry.getAmount()).sum();
    };
    public double totalInterest(){
        return getAccountEntries().stream().filter(accountEntry -> accountEntry.getDescription() == "interest").mapToDouble(entry -> entry.getAmount()).sum();
    }
    public Account addInterest(){
        double rate = getInterestStrategy().interestRate();
        double balance = getBalance();
        double interest = rate*balance;
        AccountEntry accountEntry = new AccountEntry(interest,"interest");
        addAccountEntry(accountEntry);
        return this;
    }

    public Account withdraw(double amount){
        AccountEntry accountEntry = new AccountEntry(amount,"withdraw");
        addAccountEntry(accountEntry);
        return this;
    }

    public Account deposit(double amount){
        AccountEntry accountEntry = new AccountEntry(amount,"deposit");
        addAccountEntry(accountEntry);
        return this;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", customer=" + customer +
                '}';
    }
}
