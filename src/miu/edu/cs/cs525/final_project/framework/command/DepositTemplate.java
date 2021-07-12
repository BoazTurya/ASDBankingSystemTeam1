package miu.edu.cs.cs525.final_project.framework.command;

import miu.edu.cs.cs525.final_project.framework.command.Command;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;

public abstract  class DepositTemplate implements Command {
    private AccountDAO accountDAO;
    private long accountnumber;
    private double amount;

    public DepositTemplate(AccountDAO accountDAO, long accountnumber, double amount) {
        this.accountDAO = accountDAO;
        this.accountnumber = accountnumber;
        this.amount = amount;
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

    public abstract void makeDeposit();
    @Override
    public void execute() {
        makeDeposit();

    }

    @Override
    public void unexecute() {

    }

}
