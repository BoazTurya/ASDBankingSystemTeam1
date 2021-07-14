package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountEntry;
import miu.edu.cs.cs525.final_project.framework.model.Report;
import miu.edu.cs.cs525.final_project.test.bank.BankAccountReport;

public class CreditReport extends Report {

    @Override
    public Report createReport(Account account, AccountDAO accountDAO) {
        report = "";
        for(AccountEntry accountEntry : account.getAccountEntries()){
            report += "\n" + accountEntry;
        }

        account = account.addInterest();

        double depositSum = account.totalDeposit() - ((CreditAccount) account).getLastMonthDeposit();
        double withdrawSum = account.totalWithdraw() - ((CreditAccount) account).getLastMonthWithdraw();
        double interestSum = account.totalInterest() - ((CreditAccount) account).getLastMonthInterest();

        double paymentRate = account.getPaymentStrategy().minimumPayment();
        double totalDue = paymentRate * account.getBalance();

        report += "\ntotal " + account.getTO_ACCOUNT()  + " " + depositSum;
        report += "\ntotal " + account.getFROM_ACCOUNT() + " " + withdrawSum;
        report += "\ntotal interest " + interestSum;
        report += "\nbalance " + account.getBalance();
        report += "\ntotal due " + totalDue;

        ((CreditAccount) account).setLastMonthDeposit(depositSum);
        ((CreditAccount) account).setLastMonthWithdraw(withdrawSum);
        ((CreditAccount) account).setLastMonthInterest(interestSum);

        accountDAO.updateAccount(account);
        Report accountReport = new BankAccountReport();
        accountReport.setReport(report);
        return accountReport;
    }
}
