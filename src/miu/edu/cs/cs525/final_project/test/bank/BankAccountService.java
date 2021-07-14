package miu.edu.cs.cs525.final_project.test.bank;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.service.AccountServiceImpl;
import miu.edu.cs.cs525.final_project.framework.service.CustomerService;

public class BankAccountService extends AccountServiceImpl {

    public BankAccountService(AccountDAO accountDAO, CustomerDAO customerDAO, CustomerService customerService, AccountFactory accountFactory, Report report) {
        super(accountDAO, customerDAO, customerService, accountFactory, report);
    }
}
