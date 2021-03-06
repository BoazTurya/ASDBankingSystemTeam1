package miu.edu.cs.cs525.final_project.framework.model;

import miu.edu.cs.cs525.final_project.framework.strategy.AlertStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;
import java.util.ArrayList;
import java.util.Collection;

public class Account {
    private String accountNumber;
    private Customer customer;
    private InterestStrategy interestStrategy;
    private AlertStrategy alertStrategy;
    private PaymentStrategy paymentStrategy;
    private Collection<AccountEntry> accountEntries;
    protected String TO_ACCOUNT = "deposit";
    protected String FROM_ACCOUNT = "withdraw";

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
////////////////////////////
    public  double getBalance() {
    	double balance=0.0;
    	for(AccountEntry e: accountEntries) {
    		balance+=e.getAmount();
    	}
    	return balance;
    }

    public double totalDeposit(){
        return getAccountEntries().stream().filter(accountEntry -> accountEntry.getDescription() == getTO_ACCOUNT()).mapToDouble(entry -> entry.getAmount()).sum();
    };
    public double totalWithdraw(){
        return getAccountEntries().stream().filter(accountEntry -> accountEntry.getDescription() == getFROM_ACCOUNT()).mapToDouble(entry -> entry.getAmount()).sum();
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
        AccountEntry accountEntry = new AccountEntry(amount,FROM_ACCOUNT);
        addAccountEntry(accountEntry);
        return this;
    }

    public Account deposit(double amount){
        AccountEntry accountEntry = new AccountEntry(amount,TO_ACCOUNT);
        addAccountEntry(accountEntry);
        return this;
    }


    public String getTO_ACCOUNT(){
        return TO_ACCOUNT;
    }
    public String getFROM_ACCOUNT(){
        return FROM_ACCOUNT;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", customer=" + customer +
                '}';
    }
}
