package model;

public class Account {

    protected String accountNumber;
    protected double balance;
    protected Customer customer;
	private int accountId;
	private int customerId;
	
	public Account(int accountId, String accountNumber, double balance, int customerId) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerId = customerId;
    }
	
    public Account(String accountNumber, Customer customer) {
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = 0.0;
    }
    
//    public abstract void deposit(double amount);
//    public abstract void withdraw(double amount);
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah setor harus > 0");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Jumlah tarik harus > 0");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Saldo tidak cukup");
        }
        balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) { 
    	this.balance = balance; 
    }

    public Customer getCustomer() {
        return customer;
    }
}
