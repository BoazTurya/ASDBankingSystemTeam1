package miu.edu.cs.cs525.final_project.bank.model;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

public class BankingAccount extends Account {


    public BankingAccount(Account account){

        super(account.getAccountNumber(),account.getCustomer());
        this.setAccountType(account.getAccountType());
        this.setIntrestStrategy(account.getIntrestStrategy());
        this.setTransaction(account.getAccountsEntry());
    }

    public BankingAccount(long accountNumber, Customer customer) {
        super(accountNumber, customer);
    }


}
