package miu.edu.cs.cs525.final_project.bank;

import miu.edu.cs.cs525.final_project.bank.command.BankCommandManager;
import miu.edu.cs.cs525.final_project.bank.model.BankingAccount;
import miu.edu.cs.cs525.final_project.bank.model.BankingAccountService;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAOImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        BankCommandManager commandManager =new BankCommandManager();
        AccountDAO accountDAO =new AccountDAOImpl();

        BankingAccountService bankingAccountService=new BankingAccountService(commandManager,accountDAO);


        BankingAccount creditAccount = bankingAccountService.createPersonalAccount(12223,"jaawaher","mail@mail.com"
                ,"1000 N 4 st ","fair","IA","5277", LocalDate.now(),"GOLD");
        System.out.println(creditAccount.getAccountNumber());

        //System.out.println(creditAccount.getIntrestStrategy().intrestRate());

        bankingAccountService.deposit(12223,500);
        System.out.println(creditAccount.getBalance());

    }
}