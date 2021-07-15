package miu.edu.cs.cs525.final_project.ccard.backend.command;

import miu.edu.cs.cs525.final_project.framework.command.DepositCommand;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

public class PaymentCommand extends DepositCommand {


    public PaymentCommand(AccountDAO accountDAO, long accountnumber, double amount) {
        super(accountDAO, accountnumber, amount);
    }



    @Override
    public AccountEntry makePaymentEntry() {
        return new AccountEntry(getAmount(), " effecting payment");
    }

    @Override
    public AccountEntry makeDepositEntry() {
        return null;
    }


}
