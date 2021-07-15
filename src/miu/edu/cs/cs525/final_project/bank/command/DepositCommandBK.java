package miu.edu.cs.cs525.final_project.bank.command;

import miu.edu.cs.cs525.final_project.framework.command.DepositCommand;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

public class DepositCommandBK extends DepositCommand {

    public DepositCommandBK(AccountDAO accountDAO, long accountnumber, double amount) {
        super(accountDAO, accountnumber, amount);
    }

    @Override
    public AccountEntry makePaymentEntry() {
        return null;
    }

    @Override
    public AccountEntry makeDepositEntry() {
        return new AccountEntry(getAmount(), " effecting deposit");
    }
    public boolean hasPayment(){
        return false;

    }


}
