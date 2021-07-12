package banking.command;

import miu.edu.cs.cs525.final_project.framework.command.DepositTemplate;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;

public class DepositAction extends DepositTemplate {

    public DepositAction(AccountDAO accountDAO, long accountnumber, double amount) {
        super(accountDAO, accountnumber, amount);
    }


    @Override
    public void makeDeposit() {
        Account account = getAccountDAO().loadAccount(getAccountnumber());
        account.deposit(getAmount());
        getAccountDAO().updateAccount(account);

    }
}
