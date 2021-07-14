package miu.edu.cs.cs525.final_project.test.ccard;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

public class CardFactory extends AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType) {
        if(accountType == "silver"){
            account = new CreditAccount(accountNumber,customer, InterestStrategyA.getInstance(),AlertStrategyA.getInstance(), PaymentStrategyA.getInstance());
        }
        else if(accountType == "gold"){
            account = new CreditAccount(accountNumber,customer, InterestStrategyA.getInstance(),AlertStrategyA.getInstance(), PaymentStrategyA.getInstance());
        }
        else if(accountType == "bronze"){
            account = new CreditAccount(accountNumber,customer, InterestStrategyA.getInstance(),AlertStrategyA.getInstance(), PaymentStrategyA.getInstance());
        }
        return account;
    }
}
