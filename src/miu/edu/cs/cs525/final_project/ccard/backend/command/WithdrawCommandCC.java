package miu.edu.cs.cs525.final_project.ccard.backend.command;

import miu.edu.cs.cs525.final_project.framework.command.WithdrawCommand;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

public class WithdrawCommandCC extends  WithdrawCommand{

    public WithdrawCommandCC(AccountDAO accountDAO, long accountnumber, double amount) {
        super(accountDAO, accountnumber, amount);
    }

    @Override
    public AccountEntry makeChargeEntry() {
        return null;
    }

    @Override
    public AccountEntry makeWithdrawEntry() {
        return new AccountEntry(getAmount(), " effecting withdraw");
    }

    @Override
    public boolean hasCharge(){
        return false;

    }
}
