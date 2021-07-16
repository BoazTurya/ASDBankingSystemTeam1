package miu.edu.cs.cs525.final_project.ccard.backend;

import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;

public class InterestStrategyGOLD implements InterestStrategy {
	private static volatile InterestStrategyGOLD instance;

	private InterestStrategyGOLD() {

	}
	@Override
	public double interestRate() {
		return 0.06;
	}
	public static InterestStrategyGOLD getInstance(){
		if(instance == null) {
			synchronized (InterestStrategyGOLD.class) {
				if(instance == null) {
					instance = new InterestStrategyGOLD();
				}	
			}
		}
		return instance;
	}
}

