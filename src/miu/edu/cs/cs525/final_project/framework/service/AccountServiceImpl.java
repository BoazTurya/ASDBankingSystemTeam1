package miu.edu.cs.cs525.final_project.framework.service;


import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;

public class AccountServiceImpl implements AccountService{
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;

    public AccountServiceImpl(AccountDAO accountDAO,CustomerDAO customerDAO){
        this.accountDAO = accountDAO;
        this.customerDAO = customerDAO;
    }
    
    
}
