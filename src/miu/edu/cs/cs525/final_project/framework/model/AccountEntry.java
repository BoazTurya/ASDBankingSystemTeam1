package miu.edu.cs.cs525.final_project.framework.model;

import java.util.Date;

public class AccountEntry {
    private Date date;
    private double amount;
    private String description;

    public AccountEntry(double amount, String description) {
        super();
        this.date = new Date();
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
