package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.strategy.AlertStrategy;

public class AlertStrategyA implements AlertStrategy {
    private static AlertStrategy instance = new AlertStrategyA();
    @Override
    public double alertAmount() {
        return 50;
    }

    public static AlertStrategy getInstance() {
        return instance;
    }
}
