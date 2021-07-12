package miu.edu.cs.cs525.final_project.framework.service;

import miu.edu.cs.cs525.final_project.framework.model.Customer;

import java.time.LocalDate;

public interface CustomerService {
    Customer createCustomer(String name, String email, LocalDate localDate);
    Customer getCustomer(String email);
}
