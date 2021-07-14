package miu.edu.cs.cs525.final_project.framework.dao;


import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class CustomerDAOImpl implements CustomerDAO {
    private Collection<Customer> customerCollection;

    public CustomerDAOImpl(){
        this.customerCollection = new ArrayList<>();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerCollection.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerCollection = customerCollection.stream().filter(customer1 -> customer1.getEmail() == customer.getEmail()).map(customer1 -> customer).collect(Collectors.toList());
    }

    @Override
    public Customer loadCustomer(String email) {
        Customer customer = null;
        customer = customerCollection.stream().filter(c -> c.getEmail() == email).findAny().get();
        return customer;
    }

    @Override
    public Collection<Customer> getCustomers() {
        return customerCollection;
    }
}
