package miu.edu.cs.cs525.final_project.framework.command;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.service.AccountService;

public abstract class WithdrawTemplate implements Command{
    private AccountDAO accountDAO;
    private long accountnumber;
    private double amount;


    public WithdrawTemplate(AccountDAO accountDAO, long accountnumber, double amount) {
        this.accountDAO = accountDAO;
        this.accountnumber = accountnumber;
        this.amount = amount;
    }



    public abstract void chargeAccount();
    public abstract void makeWithdraw();


    @Override
    public void execute() {
        if (hasCharge()){
            chargeAccount();
        }
        else {
            makeWithdraw();
        }

    }

    @Override
    public void unexecute() {

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
