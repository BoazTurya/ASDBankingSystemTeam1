package miu.edu.cs.cs525.final_project.test.bank.personal;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;

public class SavingStrategy implements InterestStrategy {
    @Override
    public double interestRate() {
        return 0;
    }
}
