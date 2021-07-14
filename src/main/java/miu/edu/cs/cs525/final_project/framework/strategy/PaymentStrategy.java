package miu.edu.cs.cs525.final_project.framework.strategy;

import miu.edu.cs.cs525.final_project.framework.model.Account;

public interface PaymentStrategy {
    double minimumPayment(Account account);
}
