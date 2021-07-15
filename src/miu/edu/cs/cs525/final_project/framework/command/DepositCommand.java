package miu.edu.cs.cs525.final_project.framework.command;

import miu.edu.cs.cs525.final_project.framework.command.Command;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

public abstract  class DepositCommand implements Command {
    private AccountDAO accountDAO;//
    private long accountnumber;
    private double amount;

    public DepositCommand(AccountDAO accountDAO, long accountnumber, double amount) {
        this.accountDAO = accountDAO;
        this.accountnumber = accountnumber;
        this.amount = amount;
    }


    public abstract AccountEntry makePaymentEntry();
    public abstract AccountEntry makeDepositEntry();


    @Override
    public void execute() {

        AccountEntry accountEntry;
        Account account = accountDAO.loadAccount(getAccountnumber());
        if (hasPayment()){

            accountEntry= makePaymentEntry();
        }
        else {
            accountEntry =makeDepositEntry();
        }

        account.addAccountEntry(accountEntry);

        accountDAO.updateAccount(account);


    }


    public boolean hasPayment(){
        return true;

    }

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
