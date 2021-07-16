package miu.edu.cs.cs525.final_project.bank.backend;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.framework.service.AccountService;

public class BankAccountReport extends Report {

    @Override
    public Report createReport(Account account, AccountDAO accountDAO) {
        report = "";
        for(AccountEntry accountEntry : account.getAccountEntries()){
            report += "\n" + accountEntry;
        }

        double depositSum = account.totalDeposit();
        double withdrawSum = account.totalWithdraw();
        double interestSum = account.totalInterest();

        report += "\ntotal deposit " + depositSum;
        report += "\ntotal withdraw " + withdrawSum;
        report += "\ntotal interest " + interestSum;
        report += "\nbalance " + account.getBalance();

        Report accountReport = new BankAccountReport();
        accountReport.setReport(report);
        return accountReport;
    }
}
