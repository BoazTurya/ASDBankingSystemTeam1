package miu.edu.cs.cs525.final_project.bank.backend;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAOImpl;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAOImpl;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.service.AccountServiceImpl;
import miu.edu.cs.cs525.final_project.framework.service.CustomerService;
import miu.edu.cs.cs525.final_project.framework.service.CustomerServiceImpl;

public class BankAccountService extends AccountServiceImpl {
	public BankAccountService() {
		this(new AccountDAOImpl(),new CustomerDAOImpl(),new CustomerServiceImpl(new CustomerDAOImpl()),new BankAccountFactory(),new BankAccountReport());
	}

    public BankAccountService(AccountDAO accountDAO, CustomerDAO customerDAO, CustomerService customerService, AccountFactory accountFactory, Report report) {
        super(accountDAO, customerDAO, customerService, accountFactory, report);
    }
}
