package miu.edu.cs.cs525.final_project.bank;

import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

public class PaymentStrategyA implements PaymentStrategy {
    @Override
    public double minimumPayment() {
        return 0;
    }
}
