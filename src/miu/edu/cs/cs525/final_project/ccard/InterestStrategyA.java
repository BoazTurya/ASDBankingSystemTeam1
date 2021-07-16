package miu.edu.cs.cs525.final_project.ccard;

import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;

public class InterestStrategyA implements InterestStrategy {
    private static InterestStrategy instance = new InterestStrategyA();
    @Override
    public double interestRate() {
        return 0;
    }

    public static InterestStrategy getInstance(){
        return instance;
    }
}
