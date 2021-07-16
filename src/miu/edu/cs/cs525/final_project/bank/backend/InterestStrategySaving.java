package miu.edu.cs.cs525.final_project.bank.backend;

import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;

public class InterestStrategySaving implements InterestStrategy {
    @Override
    public double interestRate() {
        return 0.5;
    }
}
