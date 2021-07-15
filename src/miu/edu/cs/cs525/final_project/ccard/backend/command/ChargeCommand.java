package miu.edu.cs.cs525.final_project.ccard.backend.command;

import miu.edu.cs.cs525.final_project.framework.command.WithdrawCommand;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

public class ChargeCommand extends WithdrawCommand {


    public ChargeCommand(AccountDAO accountDAO, long accountnumber, double amount) {
        super(accountDAO, accountnumber, amount);
    }

    @Override
    public AccountEntry makeChargeEntry() {
       return new AccountEntry(getAmount(), " effecting charge");
    }

    @Override
    public AccountEntry makeWithdrawEntry() {
        throw null;
    }


}
