package miu.edu.cs.cs525.final_project.ccard.backend.command;

import miu.edu.cs.cs525.final_project.ccard.backend.modal.intrestStrategy.BronzeStartegy;
import miu.edu.cs.cs525.final_project.ccard.backend.modal.intrestStrategy.GoldStartegy;
import miu.edu.cs.cs525.final_project.ccard.backend.modal.intrestStrategy.SilverStrategy;
import miu.edu.cs.cs525.final_project.ccard.backend.modal.minPaymentStartegey.BronzeMinPay;
import miu.edu.cs.cs525.final_project.ccard.backend.modal.minPaymentStartegey.GoldMinPay;
import miu.edu.cs.cs525.final_project.ccard.backend.modal.minPaymentStartegey.SilverMinPay;
import miu.edu.cs.cs525.final_project.framework.command.CreateAccountTemplate;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.time.LocalDate;
import java.util.Locale;

public class CreateCreditAccount extends CreateAccountTemplate {



    public CreateCreditAccount(long accountNumber, String name, String email, String street, String city,
                               String state, String zip,LocalDate dob, String accountType, AccountDAO accountDAO) {


        super(accountNumber, name, email, street, city, state, zip, dob ,accountType,accountDAO);

    }

    @Override
    public void createStartegy() {

        Account account = getAccountDAO().loadAccount(getAccountNumber());
        System.out.println("entring here");
        if(getAccountType().toUpperCase(Locale.ROOT)=="GOLD"){
            GoldMinPay goldMinPay =new GoldMinPay();
            account.setMinPaymentStartegy(goldMinPay);
            GoldStartegy goldStartegy =new GoldStartegy();
            account.setIntrestStrategy(goldStartegy);
            System.out.println(account.getIntrestStrategy().intrestRate());
            getAccountDAO().updateAccount(account);

        }

        if(getAccountType().toUpperCase(Locale.ROOT)=="SILVER"){
            account.setMinPaymentStartegy( new SilverMinPay());
            account.setIntrestStrategy(new SilverStrategy());
            getAccountDAO().updateAccount(account);


        }
        if (getAccountType().toUpperCase(Locale.ROOT)=="BRONZE"){
            account.setMinPaymentStartegy(new BronzeMinPay());
            account.setIntrestStrategy(new BronzeStartegy());
            getAccountDAO().updateAccount(account);

        }

    }


    @Override
    public boolean isCompagny(){
        return false;
    }
}
