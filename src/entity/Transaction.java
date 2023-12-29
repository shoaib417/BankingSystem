package entity;

import java.util.Date;

public class Transaction {
    private Account account;
    private String description;
    private Date dateTime;
    private String transactionType;
    private double transactionAmount;

    // Constructor
    public Transaction(Account account, String description,String transactionType, double transactionAmount) {
        this.account = account;
        this.description = description;
        this.dateTime = new Date(); // Current date and time
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }
    public Transaction(Account account, String description,String transactionType, double transactionAmount,Date datetime) {
        this.account = account;
        this.description = description;
        this.dateTime = datetime; // Current date and time
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    // Getter methods
    public Account getAccount() {
        return account;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }
}