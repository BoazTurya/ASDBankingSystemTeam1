package miu.edu.cs.cs525.final_project.framework.service;

import miu.edu.cs.cs525.final_project.framework.model.Customer;
import java.time.LocalDate;

public interface CustomerService {
    Customer createPerson(String name, String email, String street,String city, String state, String zip,LocalDate dob);
    Customer createOrganization(String name,String email,String street,String city,String state,String zip,int numberOfEmployees);
    Customer getCustomer(String email);
}
