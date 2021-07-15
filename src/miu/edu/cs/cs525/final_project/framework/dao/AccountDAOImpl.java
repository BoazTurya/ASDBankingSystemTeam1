package miu.edu.cs.cs525.final_project.framework.dao;

import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDAOImpl implements AccountDAO {

    Collection<Account> accountlist = new ArrayList<Account>();

    @Override
    public void saveAccount(Account account) {
        accountlist.add(account); // add the new
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }

    }

    @Override
    public Account loadAccount(long accountNumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber() != accountNumber) {
                continue;
            }
            return account;
        }
        return null;
    }


    @Override
    public Collection<Account> getAccounts() {
        return accountlist;
    }
}
