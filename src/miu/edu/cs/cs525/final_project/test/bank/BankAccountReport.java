package miu.edu.cs.cs525.final_project.test.bank;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;
import miu.edu.cs.cs525.final_project.framework.model.Report;

public class BankAccountReport extends Report {

    @Override
    public Report createReport(Account account) {
        report = "";
        for(AccountEntry accountEntry : account.getAccountEntries()){
            report += "\n" + accountEntry;
        }
        Report accountReport = new BankAccountReport();
        accountReport.setReport(report);
        return accountReport;
    }
}
