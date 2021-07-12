package miu.edu.cs.cs525.final_project.framework.model;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Account {
    private String accountNumber;
    private Customer customer;
    private AccountStrategy accountStrategy;
    private Collection<AccountEntry> accountEntries;

    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
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
}
