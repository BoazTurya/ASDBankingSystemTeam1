package miu.edu.cs.cs525.final_project.framework.command;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

public abstract class WithdrawCommand implements Command{
    private AccountDAO accountDAO;
    private long accountnumber;
    private double amount;


    public WithdrawCommand(AccountDAO accountDAO, long accountnumber, double amount) {
        this.accountDAO = accountDAO;
        this.accountnumber = accountnumber;
        this.amount = amount;
    }

/*
    Account account = getAccountDAO().loadAccount(getAccountnumber());
    AccountEntry entry = new AccountEntry(getAmount(), " effecting charge");
        account.addAccountEntry(entry);
        account.withdraw(getAmount());
    getAccountDAO().updateAccount(account);*/

    public abstract AccountEntry makeChargeEntry();
    public abstract AccountEntry makeWithdrawEntry();



    @Override
    public void execute() {
        AccountEntry accountEntry;

        Account account = accountDAO.loadAccount(getAccountnumber());

        if (hasCharge()){
           accountEntry=  makeChargeEntry();
        }
        else {
             accountEntry= makeWithdrawEntry() ;
        }
        account.addAccountEntry(accountEntry);
        account.withdraw(amount);
        accountDAO.updateAccount(account);

    }



    //Hook Method
    public boolean hasCharge(){
        return true;

    }



    //Setters & Getters


    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
