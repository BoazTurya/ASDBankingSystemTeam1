package miu.edu.cs.cs525.final_project.framework.model;

import java.util.Collection;

public class Organization extends Customer {
    private Collection<Customer> employeeList;
    private int numberOfEmployees;
    private Person manager;

    public Organization(String name, Address address, String email,int numberOfEmployees) {
        super(name, address, email);
        this.numberOfEmployees = numberOfEmployees;
        customerType = "Org";
    }

    public void addEmployee(Person employee){
        employeeList.add(employee);
    }
    public void removeEmployee(Person employee){
        employeeList.remove(employee);
    }
    public Collection<Customer> getEmployees(){
        return employeeList;
    }
}
