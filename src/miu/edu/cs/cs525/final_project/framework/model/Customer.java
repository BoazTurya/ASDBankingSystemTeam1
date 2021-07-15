package miu.edu.cs.cs525.final_project.framework.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    private Collection<Account> accounts;
    private Address address;
    private String email;
    private String name;



    public Customer(String name, Address address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
        accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }


    public void addEmployee(Person employee){
        throw new UnsupportedOperationException();
    }
    public void removeEmployee(Person employee){
        throw new UnsupportedOperationException();
    }
    public Collection<Customer> getEmployees(String email){
        throw new UnsupportedOperationException();
    }
}
