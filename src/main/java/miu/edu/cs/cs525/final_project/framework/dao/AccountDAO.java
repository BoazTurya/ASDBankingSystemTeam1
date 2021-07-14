package miu.edu.cs.cs525.final_project.framework.dao;


import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.util.Collection;

public interface AccountDAO {
    void saveAccount(Account account);
    void updateAccount(Account account);
    Account loadAccount(String accountnumber);
    Collection<Account> getAccounts();
}
