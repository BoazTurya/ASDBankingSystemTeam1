package miu.edu.cs.cs525.final_project.framework.dao;


import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.util.ArrayList;
import java.util.Collection;

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
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountCollection.remove(accountexist);
            accountCollection.add(account);
        }
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
