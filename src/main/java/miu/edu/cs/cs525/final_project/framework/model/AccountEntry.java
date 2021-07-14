package miu.edu.cs.cs525.final_project.framework.model;

import java.time.LocalDate;

public class AccountEntry {
    private LocalDate date;
    private double amount;
    private String description;

    public AccountEntry(double amount, String description) {
        super();
        this.date = LocalDate.now();
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
