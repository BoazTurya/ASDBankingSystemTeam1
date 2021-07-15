package miu.edu.cs.cs525.final_project.framework.service;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.observer.EmailSender;
import miu.edu.cs.cs525.final_project.framework.observer.Logger;
import miu.edu.cs.cs525.final_project.framework.observer.Subject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class AccountServiceImpl extends Subject implements AccountService {
    protected AccountDAO accountDAO;
    protected CustomerDAO customerDAO;
    protected CustomerService customerService;
    protected AccountFactory accountFactory;
    protected Report report;
    public AccountServiceImpl(AccountDAO accountDAO,CustomerDAO customerDAO,CustomerService customerService,AccountFactory accountFactory,Report report){
        this.accountDAO = accountDAO;
        this.customerDAO = customerDAO;
        this.customerService = customerService;
        this.accountFactory = accountFactory;
        this.report = report;

        this.addObserver(Logger.getInstance());
        this.addObserver(EmailSender.getInstance());
    }

    @Override
    public Account createPersonalAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, LocalDate dob, String accountType) {
        Customer customer = customerService.createPerson(name,email,street,city,state,zip,dob);
        Account account = accountFactory.createAccount(accountNumber,customer, accountType);
        accountDAO.saveAccount(account);
        return account;}

    @Override
    public Account createOrganizationAccount(String accountNumber, String name, String email, String street, String city, String state, String zip, int numberOfEmployees, String accountType) {
        Customer customer = customerService.createOrganization(name,email,street,city,state,zip,numberOfEmployees);
        Account account = accountFactory.createAccount(accountNumber,customer, accountType);
        accountDAO.saveAccount(account);
        return account;}

    @Override
    public final Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    public Report generateReport(String accountNumber){
        Account account = accountDAO.loadAccount(accountNumber);
        return report.generateReport(account,accountDAO);
    }

    public final double getBalance(String accountNumber){
        return accountDAO.loadAccount(accountNumber).getBalance();}

    @Override
    public final void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account = account.deposit(amount);
        accountDAO.updateAccount(account);
        this.notifyAllObservers(account);}

    @Override
    public final void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account = account.withdraw(amount);
        accountDAO.updateAccount(account);
        this.notifyAllObservers(account);
    }

    @Override
    public void calculateInterest() {

        Collection<Account> updatedAccounts = new ArrayList<>();
 
        for (Account account: accountDAO.getAccounts()){
            Account updatedAccount = account.addInterest();
            updatedAccounts.add(updatedAccount);
//            accountDAO.updateAccount(account);
        }

        for(Account updatedAccount : updatedAccounts) accountDAO.updateAccount(updatedAccount);

    }
}
