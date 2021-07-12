package miu.edu.cs.cs525.final_project.framework.service;


import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.time.LocalDate;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDAO customerDAO;
    public CustomerServiceImpl(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }
    @Override
    public Customer createCustomer(String name, String email, LocalDate localDate) {
        return null;
    }

    @Override
    public Customer getCustomer(String email) {
        return null;
    }
}
