package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAOImpl;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAOImpl;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.service.CustomerServiceImpl;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOImpl();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl(customerDAO);
        AccountFactory accountFactory = new CardFactory();
        Report report = new CreditReport();

        CardAccountServiceImpl creditAccountService = new CardAccountServiceImpl(accountDAO,customerDAO,customerService,accountFactory,report);

        creditAccountService.createPersonalAccount("111","Abenezer","ab@email.com","street","city","state","zip", LocalDate.now(),"silver",LocalDate.now());
        creditAccountService.createOrganizationAccount("112","hope","hope@com.org","street","city","state","zip",6,"gold",LocalDate.now());

//        System.out.println(accountDAO.getAccounts());

        creditAccountService.charge("112",141);
        creditAccountService.charge("112",31);
        creditAccountService.makePayment("112",202);


        creditAccountService.charge("111",121);
        creditAccountService.charge("111",101);
        creditAccountService.makePayment("111",100);

        report = creditAccountService.generateReport("111");
        System.out.println("Report : " + report.getReport());

        report = creditAccountService.generateReport("112");
        System.out.println("Report : " + report.getReport());
    }
}
