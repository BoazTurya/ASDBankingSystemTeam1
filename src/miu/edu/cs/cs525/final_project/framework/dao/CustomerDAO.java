package miu.edu.cs.cs525.final_project.framework.dao;


import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.util.Collection;

public interface CustomerDAO {
    void saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    Customer loadCustomer(String email);
    Collection<Customer> getCustomers();
}
