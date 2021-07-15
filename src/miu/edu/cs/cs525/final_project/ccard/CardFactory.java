package miu.edu.cs.cs525.final_project.ccard;
import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

public class CardFactory extends AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType) {
        if(accountType == "gold"){
            account = new CardAccount(accountNumber,customer, InterestStrategyA.getInstance(),AlertStrategyA.getInstance(), PaymentStrategyA.getInstance());
        }
        else if(accountType == "silver"){
            account = new CardAccount(accountNumber,customer, InterestStrategyA.getInstance(),AlertStrategyA.getInstance(), PaymentStrategyA.getInstance());
        }
        else if(accountType == "bronze"){
            account = new CardAccount(accountNumber,customer, InterestStrategyA.getInstance(),AlertStrategyA.getInstance(), PaymentStrategyA.getInstance());
        }
        return account;
    }
}
