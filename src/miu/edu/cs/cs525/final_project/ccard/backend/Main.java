package miu.edu.cs.cs525.final_project.ccard.backend;

import miu.edu.cs.cs525.final_project.ccard.backend.command.CCardCommandManager;
import miu.edu.cs.cs525.final_project.ccard.backend.modal.CreditAccount;
import miu.edu.cs.cs525.final_project.ccard.backend.modal.CreditAcountservice;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAOImpl;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        CCardCommandManager commandManager =new CCardCommandManager();
        AccountDAO accountDAO =new AccountDAOImpl();

        CreditAcountservice creditAcountservice=new CreditAcountservice(commandManager,accountDAO);
        CreditAccount creditAccount =creditAcountservice.createPersonalAccount(12223,"jaawaher","mail@mail.com"
        ,"1000 N 4 st ","fair","IA","5277", LocalDate.now(),"gold");
        System.out.println(creditAccount.getAccountNumber());
        System.out.println(creditAccount.getExpirationDate());
        //System.out.println(creditAccount.getIntrestStrategy().intrestRate());

        //creditAcountservice.pay(12223,100);
        System.out.println(creditAccount.getBalance());










    }
}
