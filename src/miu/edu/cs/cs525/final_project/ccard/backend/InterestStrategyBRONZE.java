package miu.edu.cs.cs525.final_project.ccard.backend;

import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;

public class InterestStrategyBRONZE implements InterestStrategy {
    private static volatile InterestStrategyBRONZE instance;
    @Override
    public double interestRate() {
        return 0.1;
    }

    public static InterestStrategyBRONZE getInstance(){
    	if(instance == null) {
    		synchronized(InterestStrategyGOLD.class) {
    			if(instance == null) {
    				instance = new InterestStrategyBRONZE();
    			}
    		}
    	}
        return instance;
    }
}
