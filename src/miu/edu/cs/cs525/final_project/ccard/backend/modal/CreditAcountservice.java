package miu.edu.cs.cs525.final_project.ccard.backend.modal;


import miu.edu.cs.cs525.final_project.ccard.backend.command.*;
import miu.edu.cs.cs525.final_project.framework.command.IntrestTemplate;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.service.AccountServiceImpl;

import java.time.LocalDate;
import java.util.Collection;

public class CreditAcountservice extends AccountServiceImpl {

    CCardCommandManager commandManager ;
    IntrestCommandCC intrestCommandCC;
    ChargeCommand chargeCommand;
    AccountDAO accountDAO ;
    WithdrawCommandCC withdrawCommand;
    PaymentCommand paymentCommand;
    CreateCreditAccount createCreditAccount;

    public CreditAcountservice(CCardCommandManager commandManager, AccountDAO accountDAO){
        this.commandManager =commandManager;
        this.accountDAO=accountDAO;
    }



    @Override
    public void withdraw(long accountNumber, double amount) {

        withdrawCommand=new WithdrawCommandCC(accountDAO,accountNumber,amount);
        commandManager.setCommand(withdrawCommand);

    }

    public void charge(long accountNumber, double amount) {
        chargeCommand =new ChargeCommand(accountDAO,accountNumber,amount);
        commandManager.setCommand(chargeCommand);

    }
    public void pay(long accountNumber, double amount) {

        paymentCommand =new PaymentCommand(accountDAO,accountNumber,amount);
        commandManager.setCommand(paymentCommand);

    }

    @Override
    public void addIntrest() {

        commandManager.setCommand(intrestCommandCC);

    }
    @Override
    public CreditAccount createPersonalAccount(long accountNumber, String name, String email,
                                         String street, String city, String state, String zip,
                                         LocalDate expirationDate, String accountType) {


        createCreditAccount=new CreateCreditAccount(accountNumber,name,email,street,city,state,zip,
                expirationDate,accountType,accountDAO);
        commandManager.setCommand(createCreditAccount);
        Account account = createCreditAccount.getAccountDAO().loadAccount(accountNumber);

        return new CreditAccount(account,expirationDate);
    }



    @Override
    public String generateReport() {
        return null;
    }


    @Override
    public Account getAccount(long accountNumber) {
        return null;

    }

    @Override
    public Collection<Account> getAllAccounts() {
        return null;
    }

    @Override
    public void deposit(long accountNumber, double amount) {


    }


}
