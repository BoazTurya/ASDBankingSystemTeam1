package miu.edu.cs.cs525.final_project.test.bank.personal;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import miu.edu.cs.cs525.final_project.framework.service.AccountServiceImpl;
import miu.edu.cs.cs525.final_project.framework.service.CustomerService;

public class BankAccountService extends AccountServiceImpl {
    public BankAccountService(AccountDAO accountDAO, CustomerDAO customerDAO, CustomerService customerService) {
        super(accountDAO, customerDAO, customerService);
    }

    @Override
    public void calculateInterest() {

    }

    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType) {
        return null;
    }
}
