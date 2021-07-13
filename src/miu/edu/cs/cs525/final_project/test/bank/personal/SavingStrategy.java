package miu.edu.cs.cs525.final_project.test.bank.personal;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.AccountStrategy;

public class SavingStrategy implements AccountStrategy {
    @Override
    public double interestRate() {
        return 0;
    }

    @Override
    public double alertAmount() {
        return 0;
    }

    @Override
    public double MinimumPayment(Account account) {
        return 0;
    }
}
