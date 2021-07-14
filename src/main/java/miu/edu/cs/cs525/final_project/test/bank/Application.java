package miu.edu.cs.cs525.final_project.test.bank;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAOImpl;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAOImpl;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.service.CustomerServiceImpl;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerDAO);
        AccountFactory accountFactory = new BankAccountFactory();
        BankAccountService bankAccountService = new BankAccountService(accountDAO,customerDAO,customerService,accountFactory);

        bankAccountService.createPersonalAccount("111","Abenezer","raeycareer@gmail.com","street","city","state","zip", LocalDate.now(),"saving");
        double balance = bankAccountService.getBalance("111");
        System.out.println("BALANCE : " + balance);

        bankAccountService.deposit("111",800);
        balance = bankAccountService.getBalance("111");
        System.out.println("BALANCE : " + balance);

        bankAccountService.withdraw("111",600);
        balance = bankAccountService.getBalance("111");
        System.out.println("BALANCE : " + balance);
    }
}
