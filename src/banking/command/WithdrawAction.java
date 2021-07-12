package banking.command;

import miu.edu.cs.cs525.final_project.framework.command.WithdrawTemplate;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;

public class WithdrawAction extends WithdrawTemplate {


    public WithdrawAction(AccountDAO accountDAO, long accountnumber, double amount) {
        super(accountDAO, accountnumber, amount);
    }

    @Override
    public void chargeAccount() {
    }

    @Override
    public void makeWithdraw() {

        Account account = getAccountDAO().loadAccount(getAccountnumber());
        account.withdraw(getAmount());
        getAccountDAO().updateAccount(account);

    };


    public boolean hasCharge(){
        return false;

    }
}
