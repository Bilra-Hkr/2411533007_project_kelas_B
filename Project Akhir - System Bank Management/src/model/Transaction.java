package model;

import java.time.LocalDateTime;

public class Transaction {

    private int transactionId;
    private String accountNumber;
    private String type;  
    private double amount;
    private LocalDateTime transactionDate;

    // Constructor untuk transaksi baru
    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
    }

    // Constructor untuk database
    public Transaction(int transactionId, String accountNumber,
                       String type, double amount,
                       LocalDateTime transactionDate) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    // Getter
    public int getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }
}
