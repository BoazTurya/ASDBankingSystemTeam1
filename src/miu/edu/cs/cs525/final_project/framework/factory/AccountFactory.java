package miu.edu.cs.cs525.final_project.framework.factory;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

public abstract class AccountFactory {
    public Account account;
    public abstract Account createAccount(String accountNumber, Customer customer, String accountType);
}
