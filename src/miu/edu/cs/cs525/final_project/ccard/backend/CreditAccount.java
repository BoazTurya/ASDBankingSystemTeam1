package miu.edu.cs.cs525.final_project.ccard.backend;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import miu.edu.cs.cs525.final_project.framework.strategy.AlertStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

import java.time.LocalDate;

public class CreditAccount extends Account {
    private LocalDate expirationDate;
    private double lastMonthDeposit;
    private double lastMonthWithdraw;
    private double lastMonthInterest;
    public CreditAccount(String accountNumber, Customer customer, InterestStrategy accountStrategy, AlertStrategy alertStrategy, PaymentStrategy paymentStrategy) {
        super(accountNumber, customer, accountStrategy, alertStrategy, paymentStrategy);
        TO_ACCOUNT = "payment";
        FROM_ACCOUNT = "charge";
    }

    @Override
    public double getBalance() {
        return totalWithdraw() + totalInterest() - totalDeposit();
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getLastMonthDeposit() {
        return lastMonthDeposit;
    }

    public void setLastMonthDeposit(double lastMonthDeposit) {
        this.lastMonthDeposit = lastMonthDeposit;
    }

    public double getLastMonthWithdraw() {
        return lastMonthWithdraw;
    }

    public void setLastMonthWithdraw(double lastMonthWithdraw) {
        this.lastMonthWithdraw = lastMonthWithdraw;
    }

    public double getLastMonthInterest() {
        return lastMonthInterest;
    }

    public void setLastMonthInterest(double lastMonthInterest) {
        this.lastMonthInterest = lastMonthInterest;
    }

}
