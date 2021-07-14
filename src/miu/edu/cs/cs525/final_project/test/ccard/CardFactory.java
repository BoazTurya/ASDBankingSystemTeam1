package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import miu.edu.cs.cs525.final_project.framework.strategy.InterestStrategy;
import miu.edu.cs.cs525.final_project.test.bank.BankAccount;
import miu.edu.cs.cs525.final_project.test.bank.PaymentStrategyA;

public class CardFactory extends AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType) {
        if(accountType == "silver"){
            account = new CreditAccount(accountNumber,customer, InterestStrategyA.getInstance(),AlertStrategyA.getInstance(), account.getPaymentStrategy());
        }
        else if(accountType == "gold"){
            account = new CreditAccount(accountNumber,customer, InterestStrategyA.getInstance(),AlertStrategyA.getInstance(), account.getPaymentStrategy());
        }
        return account;
    }
}
