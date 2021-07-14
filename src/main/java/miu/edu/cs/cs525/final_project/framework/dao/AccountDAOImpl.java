package miu.edu.cs.cs525.final_project.framework.dao;


import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class AccountDAOImpl implements AccountDAO {
    private Collection<Account> accountCollection;

    public AccountDAOImpl(){
        this.accountCollection = new ArrayList<>();
    }
    @Override
    public void saveAccount(Account account) {
        accountCollection.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountCollection = accountCollection.stream().filter(account1 -> account1.getAccountNumber() == account.getAccountNumber()).map(account1 -> account).collect(Collectors.toList());
    }

    @Override
    public Account loadAccount(String accountnumber) {
        Account account = null;
        account = accountCollection.stream().filter(acc -> acc.getAccountNumber() == accountnumber).findAny().get();
        return account;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountCollection;
    }
}
