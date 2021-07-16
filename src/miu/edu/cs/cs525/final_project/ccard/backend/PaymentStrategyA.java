package miu.edu.cs.cs525.final_project.ccard.backend;

import miu.edu.cs.cs525.final_project.framework.strategy.PaymentStrategy;

public class PaymentStrategyA implements PaymentStrategy {
    public static PaymentStrategy instance = new PaymentStrategyA();

    @Override
    public double minimumPayment() {
        return 0.1;
    }

    public static PaymentStrategy getInstance() {
        return instance;
    }
}
