package miu.edu.cs.cs525.final_project.framework.service;


import miu.edu.cs.cs525.final_project.framework.command.*;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;

import java.time.LocalDate;
import java.util.Collection;

public abstract class AccountServiceImpl implements AccountService{

    private  CustomerDAO customerDAO;
    private AccountDAO accountDAO;

    @Override
    public Account getAccount(long accountNumber) {
        return null;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return null;
    }

    @Override
    public abstract void  deposit(long accountNumber, double amount) ;

    @Override
    public abstract void withdraw(long accountNumber, double amount) ;

    @Override
    public abstract  String  generateReport() ;

    @Override
    public abstract void addIntrest() ;


    @Override
    public abstract Account createPersonalAccount(long accountNumber, String name, String email, String street, String city, String state, String zip, LocalDate dob, String accountType) ;




}
