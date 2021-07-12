package cCard.command;

import miu.edu.cs.cs525.final_project.framework.command.WithdrawTemplate;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;

public class ChargeAction extends WithdrawTemplate {

    public ChargeAction(AccountDAO accountDAO, long accountnumber, double amount) {
        super(accountDAO, accountnumber, amount);
    }

    @Override
    public void chargeAccount() {

        Account account = getAccountDAO().loadAccount(getAccountnumber());
        account.withdraw(getAmount());
        getAccountDAO().updateAccount(account);


    }

    @Override
    public void makeWithdraw() {

    }

}
