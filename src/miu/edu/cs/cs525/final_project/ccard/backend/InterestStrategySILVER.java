package miu.edu.cs.cs525.final_project.ccard.backend;

import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;

public class InterestStrategySILVER implements InterestStrategy {
    private static volatile InterestStrategySILVER instance;
    @Override
    public double interestRate() {
        return 0.08;
    }
    private InterestStrategySILVER() {
    	
    }

    public static InterestStrategySILVER getInstance(){
    	if(instance == null) {
    		synchronized (InterestStrategySILVER.class) {
    			if(instance == null) {
    				instance = new InterestStrategySILVER();
    			}	
			}
    	}
        return instance;
    }
}
