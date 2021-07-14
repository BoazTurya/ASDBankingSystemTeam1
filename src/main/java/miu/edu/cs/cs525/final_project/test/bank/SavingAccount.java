package miu.edu.cs.cs525.final_project.test.bank;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import miu.edu.cs.cs525.final_project.framework.strategy.AlertStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;
import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

public class SavingAccount extends Account {
    public SavingAccount(String accountNumber, Customer customer, InterestStrategy accountStrategy, AlertStrategy alertStrategy, PaymentStrategy paymentStrategy) {
        super(accountNumber, customer, accountStrategy, alertStrategy, paymentStrategy);
    }
}
