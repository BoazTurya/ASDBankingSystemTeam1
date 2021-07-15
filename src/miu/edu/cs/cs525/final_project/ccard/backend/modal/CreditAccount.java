package miu.edu.cs.cs525.final_project.ccard.backend.modal;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.time.LocalDate;

public class CreditAccount extends Account {
    LocalDate expirationDate;


    public CreditAccount(Account account,LocalDate expirationDate){
        super(account.getAccountNumber(),account.getCustomer());
        this.setAccountType(account.getAccountType());
        this.setMinPaymentStartegy(account.getMinPaymentStartegy());
        this.setIntrestStrategy(account.getIntrestStrategy());
        this.setTransaction(account.getAccountsEntry());
        this.setCustomer(account.getCustomer());
        this.expirationDate=expirationDate;
    }
    public CreditAccount(long accountNumber, Customer customer) {
        super(accountNumber, customer);

    }

    public CreditAccount(Account account) {
        super(account.getAccountNumber(), account.getCustomer() );
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(super.toString());
        result.append(expirationDate.toString());
        return result.toString();
    }
}
