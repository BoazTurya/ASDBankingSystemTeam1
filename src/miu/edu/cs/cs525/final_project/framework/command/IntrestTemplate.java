package miu.edu.cs.cs525.final_project.framework.command;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;

import java.util.Collection;

public abstract class IntrestTemplate implements Command {
    AccountDAO accountDAO;

    public  void addIntrest(){
        AccountDAO accountDAO =getAccountDAO();
        Collection<Account> listAccount =accountDAO.getAccounts();

        for (Account account :listAccount){
            double intrest= account.getIntrestStrategy().intrestRate();
            AccountEntry accountEntry=new AccountEntry(intrest,"intrest");
            accountEntry.setAmount(intrest);
            accountDAO.updateAccount(account);
        }
    }

    @Override
    public void execute() {
        addIntrest();

    }


    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
}
