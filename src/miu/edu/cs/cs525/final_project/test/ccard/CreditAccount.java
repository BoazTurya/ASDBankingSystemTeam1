package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import miu.edu.cs.cs525.final_project.framework.strategy.AlertStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

import java.time.LocalDate;

public class CreditAccount extends Account {
    private LocalDate expirationDate;
    public CreditAccount(String accountNumber, Customer customer, InterestStrategy accountStrategy, AlertStrategy alertStrategy, PaymentStrategy paymentStrategy) {
        super(accountNumber, customer, accountStrategy, alertStrategy, paymentStrategy);
    }


}
