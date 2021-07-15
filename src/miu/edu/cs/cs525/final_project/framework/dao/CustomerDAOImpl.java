package miu.edu.cs.cs525.final_project.framework.dao;

import miu.edu.cs.cs525.final_project.framework.model.Account;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerDAOImpl implements CustomerDAO{
    Collection<Customer> customerList = new ArrayList<Customer>();


    @Override
    public void saveCustomer(Customer customer) {
        customerList.add(customer);

    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer customerexist = loadCustomer(customer.getEmail());
        if (customerexist != null) {
            customerList.remove(customerexist); // remove the old
            customerList.add(customerexist); // add the new
        }

    }

    @Override
    public Customer loadCustomer(String email) {

        for (Customer customer : customerList) {
            if (customer.getEmail() != email) {
                continue;
            }
            return customer;
        }
        return null;
    }

    @Override
    public Collection<Customer> getCustomers() {
        return customerList;
    }










}
