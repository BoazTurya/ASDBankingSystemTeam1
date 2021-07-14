package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

public class PaymentStrategyA implements PaymentStrategy {
    public static PaymentStrategy instance = new PaymentStrategyA();

    @Override
    public double minimumPayment() {
        return 0;
    }

    public static PaymentStrategy getInstance() {
        return instance;
    }
}
