package miu.edu.cs.cs525.final_project.framework.service;


import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.model.Address;
import miu.edu.cs.cs525.final_project.framework.model.Customer;
import miu.edu.cs.cs525.final_project.framework.model.Organization;
import miu.edu.cs.cs525.final_project.framework.model.Person;

import java.time.LocalDate;

public class CustomerServiceImpl implements CustomerService{
    private CustomerDAO customerDAO;
    public CustomerServiceImpl(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    @Override
    public Customer createPerson(String name, String email, String street, String city, String state, String zip, LocalDate dob) {
        Address address = new Address(street,city,state,zip);
        Customer customer = new Person(name,address,email,dob);
        customerDAO.saveCustomer(customer);
        return customer;
    }

    @Override
    public Customer createOrganization(String name, String email, String street, String city, String state, String zip, int numberOfEmployees) {
        Address address = new Address(street,city,state,zip);
        Customer customer = new Organization(name,address,email,numberOfEmployees);
        customerDAO.saveCustomer(customer);
        return customer;
    }

    @Override
    public Customer getCustomer(String email) {
        Customer  customer = customerDAO.loadCustomer(email);
        return customer;
    }
}
