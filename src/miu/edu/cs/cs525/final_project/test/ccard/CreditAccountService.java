package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.service.AccountServiceImpl;
import miu.edu.cs.cs525.final_project.framework.service.CustomerService;

import java.time.LocalDate;

public class CreditAccountService extends AccountServiceImpl {
    public CreditAccountService(AccountDAO accountDAO, CustomerDAO customerDAO, CustomerService customerService, AccountFactory accountFactory, Report report) {
        super(accountDAO, customerDAO, customerService, accountFactory, report);
    }

    public CreditAccount createPersonalAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, LocalDate dob, String accountType,LocalDate expirationDate) {
        CreditAccount account = (CreditAccount) super.createPersonalAccount(accountNumber, name, email, street, city, state, zip, dob, accountType);
        account.setExpirationDate(expirationDate);
        accountDAO.updateAccount(account);
        return account;
    }

    public CreditAccount createOrganizationAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, int numberOfEmployees, String accountType, LocalDate expirationDate) {
        CreditAccount account = (CreditAccount)  super.createOrganizationAccount(accountNumber, name, email, street, city, state, zip, numberOfEmployees, accountType);
        account.setExpirationDate(expirationDate);
        accountDAO.updateAccount(account);
        return account;
    }

    @Override
    public Report generateReport(String accountNumber) {
        return super.generateReport(accountNumber);
    }
}
