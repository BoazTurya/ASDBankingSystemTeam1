package miu.edu.cs.cs525.final_project.framework.model;

public interface AccountStrategy {
    double interestRate();
    double alertAmount();
    double MinimumPayment(Account account);
}
