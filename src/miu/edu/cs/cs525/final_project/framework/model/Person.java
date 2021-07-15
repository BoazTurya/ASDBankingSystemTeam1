package miu.edu.cs.cs525.final_project.framework.model;

import java.time.LocalDate;

public class Person extends Customer {
    private LocalDate dob;

    public Person(String name, Address address, String email,LocalDate dob) {
        super(name, address, email);
        this.dob=dob;
    }


    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
