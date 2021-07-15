package miu.edu.cs.cs525.final_project.bank.model;

import miu.edu.cs.cs525.final_project.bank.command.BankCommandManager;
import miu.edu.cs.cs525.final_project.bank.command.CreatePersonalAccountBk;
import miu.edu.cs.cs525.final_project.bank.command.DepositCommandBK;
import miu.edu.cs.cs525.final_project.bank.command.WithdrawCommandBK;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.service.AccountServiceImpl;

import java.time.LocalDate;
import java.util.Collection;

public class BankingAccountService  extends AccountServiceImpl {

    BankCommandManager bankCommandManager ;
    CreatePersonalAccountBk createPersonalAccountBk ;
    DepositCommandBK depositCommandBK ;
    WithdrawCommandBK withdrawCommandBK;
    AccountDAO accountDAO ;


    public BankingAccountService(BankCommandManager bankCommandManager, AccountDAO accountDAO) {
        this.bankCommandManager = bankCommandManager;
        this.accountDAO = accountDAO;
    }

    @Override
    public BankingAccount createPersonalAccount(long accountNumber, String name,
                                                String email, String street, String city, String state, String zip,
                                                LocalDate dob, String accountType) {

      createPersonalAccountBk= new CreatePersonalAccountBk(accountNumber,name,email,street,city,state,zip,dob,
              accountType,accountDAO);
      bankCommandManager.setCommand(createPersonalAccountBk);
      Account account =accountDAO.loadAccount(accountNumber);
      BankingAccount bankingAccount = new BankingAccount(account);
        return bankingAccount;

    }

    @Override
    public Account getAccount(long accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    @Override
    public void deposit(long accountNumber, double amount) {

        depositCommandBK =new DepositCommandBK(accountDAO ,accountNumber,amount);
        bankCommandManager.setCommand(depositCommandBK);

    }

    @Override
    public void withdraw(long accountNumber, double amount) {

        withdrawCommandBK=new WithdrawCommandBK(accountDAO,accountNumber,amount);
        bankCommandManager.setCommand(withdrawCommandBK);

    }

    @Override
    public String generateReport() {
        return null;
    }

    @Override
    public void addIntrest() {

    }


}
