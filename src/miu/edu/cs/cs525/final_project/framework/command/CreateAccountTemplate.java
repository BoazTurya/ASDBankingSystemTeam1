package miu.edu.cs.cs525.final_project.framework.command;


import miu.edu.cs.cs525.final_project.ccard.backend.command.CreateCreditAccount;
import miu.edu.cs.cs525.final_project.framework.dao.AccountDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAO;
import miu.edu.cs.cs525.final_project.framework.dao.CustomerDAOImpl;
import miu.edu.cs.cs525.final_project.framework.model.*;

import java.time.LocalDate;

public   abstract  class CreateAccountTemplate implements Command {
    private AccountDAO accountDAO;
    private CustomerDAO customerDAO;
    String  zip;
    String state;
    String city;
    String street;
    String email ;
    String name ;
    long accountNumber;
    int numberOfEmployee;
    String accountType;
    LocalDate keyDate ;
    LocalDate dob ;
    Address address;

    public CreateAccountTemplate(long accountNumber, String name, String email,
                               String street, String city, String state, String zip, LocalDate keyDate,
                               String accountType,AccountDAO accountDAO){
        this.accountNumber=accountNumber;
        this.name=name;
        this.email=email;
        this.state=state;
        this.city=city;
        this.zip=zip;
        this.street=street;
        this.keyDate=keyDate;
        this.accountType=accountType;
        this.accountDAO=accountDAO;
        customerDAO=new CustomerDAOImpl();

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }




    public abstract void createStartegy();
    public Address createAddress(String street, String city, String state, String zip){
        return new Address(street,state,city,zip);

    }

    @Override
    public void execute() {
        Account account ;
        address = createAddress(street,state,city,zip);

        if (isCompagny()){
            Organization organization=new Organization(name,address,email,numberOfEmployee);
            customerDAO.saveCustomer(organization);
            account=createOrganizationAccount(accountNumber,organization);

        }
        else {
            Person person = new Person(name,address,email,dob);
            customerDAO.saveCustomer(person);
            account=createPersoanlAccount(accountNumber,person);

        }

        account.setAccountType(accountType);
        System.out.println(accountType);
        accountDAO.updateAccount(account);
        createStartegy();



    }


    public  Account createPersoanlAccount(long accountNumber, Person person){

        return new Account(accountNumber,person);


    }

    Account createOrganizationAccount(long accountNumber,Organization organization){

      return new Account(accountNumber,organization);


    }





    public boolean isCompagny(){
        return true;
    }





    //Setters and Getters

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }


    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }


    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAccountType() {
        return accountType;
    }

}
