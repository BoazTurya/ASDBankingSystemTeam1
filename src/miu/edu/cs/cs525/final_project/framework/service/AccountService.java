package miu.edu.cs.cs525.final_project.framework.service;

import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.util.Collection;

public interface AccountService {
    Account createAccount(long accountNumber, String customerName);
    Account getAccount(long accountNumber);
    Collection<Account> getAllAccounts();
    public void deposit(long accountNumber, double amount);
    void withdraw (long accountNumber, double amount);


}
