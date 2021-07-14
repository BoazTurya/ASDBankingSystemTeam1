package miu.edu.cs.cs525.final_project.test.ccard;

import miu.edu.cs.cs525.final_project.framework.factory.AccountFactory;
import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

public class CardFactory extends AccountFactory {
    @Override
    public CreditAccount createAccount(String accountNumber, Customer customer, String accountType) {
        return null;
    }
}
