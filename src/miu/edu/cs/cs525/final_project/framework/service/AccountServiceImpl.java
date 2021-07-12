package miu.edu.cs.cs525.final_project.framework.service;


import miu.edu.cs.cs525.final_project.framework.command.DepositTemplate;
import miu.edu.cs.cs525.final_project.framework.command.HistoryList;
import miu.edu.cs.cs525.final_project.framework.command.WithdrawTemplate;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.util.Collection;

public class AccountServiceImpl implements AccountService{
    HistoryList historyList ;
    WithdrawTemplate withdrawTemplate;// withdrawCommand
    DepositTemplate depositTemplate;//DepositeCommand
    private CustomerDAO customerDAO;
    private AccountDAO accountDAO;

    public AccountServiceImpl(HistoryList historyList,CustomerDAO customerDAO, AccountDAO accountDAO){
      this.historyList=historyList;
      this.customerDAO = customerDAO;
      this.accountDAO=accountDAO;
    }





    @Override
    public Account createAccount(long accountNumber, String customerName) {

        return null;
    }

    @Override
    public Account getAccount(long accountNumber) {
        return null;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return null;
    }

    @Override
    public void deposit(long accountNumber, double amount) {
        depositTemplate.setAccountnumber(accountNumber);
        depositTemplate.setAccountDAO(accountDAO);
        depositTemplate.setAmount(amount);
        historyList.setCommand(depositTemplate);

    }

    @Override
    public void withdraw(long accountNumber, double amount) {
        withdrawTemplate.setAccountnumber(accountNumber);
        withdrawTemplate.setAccountDAO(accountDAO);
        withdrawTemplate.setAmount(amount);
        historyList.setCommand(withdrawTemplate);

    }


}
