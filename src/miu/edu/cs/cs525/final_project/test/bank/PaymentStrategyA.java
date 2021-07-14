package miu.edu.cs.cs525.final_project.test.bank;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

public class PaymentStrategyA implements PaymentStrategy {
    @Override
    public double MinimumPayment(Account account) {
        return 0;
    }
}
