package miu.edu.cs.cs525.final_project.test.bank;

import miu.edu.cs.cs525.final_project.framework.strategy.AlertStrategy;

public class AlertStrategyA implements AlertStrategy {
    @Override
    public double alertAmount() {
        return 100;
    }
}
