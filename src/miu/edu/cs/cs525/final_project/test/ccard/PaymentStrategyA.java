package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

public class PaymentStrategyA implements PaymentStrategy {
    @Override
    public double minimumPayment(Account account) {
        return 0;
    }
}
