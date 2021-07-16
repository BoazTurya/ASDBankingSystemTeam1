package miu.edu.cs.cs525.final_project.bank;

import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

public class BankAccountFactory extends AccountFactory {
    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType) {
        if(accountType == "saving"){
            account =  new BankAccount(accountNumber,customer,new InterestStrategyA(),new AlertStrategyA(),new PaymentStrategyA());
        }
        else if(accountType == "checking"){
            account = new BankAccount(accountNumber,customer,new InterestStrategyA(),new AlertStrategyA(),new PaymentStrategyA());
        }
        return account;
    }
}
