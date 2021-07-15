package miu.edu.cs.cs525.final_project.bank.command;

import miu.edu.cs.cs525.final_project.bank.model.CheckingStrategy;
import miu.edu.cs.cs525.final_project.bank.model.SavingStrategy;
import miu.edu.cs.cs525.final_project.framework.command.CreateAccountTemplate;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.time.LocalDate;
import java.util.Locale;

public class CreatePersonalAccountBk extends CreateAccountTemplate {


    public CreatePersonalAccountBk(long accountNumber, String name, String email, String street, String city, String state, String zip, LocalDate keyDate, String accountType, AccountDAO accountDAO) {
        super(accountNumber, name, email, street, city, state, zip, keyDate, accountType, accountDAO);
    }

    @Override
    public void createStartegy() {
        Account account = getAccountDAO().loadAccount(getAccountNumber());



        if(getAccountType().toUpperCase(Locale.ROOT)=="CHECKING"){
            account.setIntrestStrategy(new CheckingStrategy());
            getAccountDAO().updateAccount(account);

        }

        if(getAccountType().toUpperCase(Locale.ROOT)=="SAVING"){
            account.setIntrestStrategy(new SavingStrategy());
            getAccountDAO().updateAccount(account);

        }



    }
}
