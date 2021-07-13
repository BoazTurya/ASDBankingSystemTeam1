package miu.edu.cs.cs525.final_project.framework.service;


import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.model.Address;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import java.time.LocalDate;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDAO customerDAO;
    public CustomerServiceImpl(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer createCustomer(String name, String email, String street, String city, String state, String zip) {
        Address address = new Address(street,city,state,zip);
        Customer customer = new Customer(name,address,email);
        customerDAO.saveCustomer(customer);
        return customer;
    }

    @Override
    public Customer getCustomer(String email) {
        Customer  customer = customerDAO.loadCustomer(email);
        return customer;
    }
}
