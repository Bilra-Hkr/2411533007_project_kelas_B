package model;

public class SavingAccount extends Account {
    private static final double MIN_BALANCE = 50000;

    public SavingAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override //override method dari abstrack class account utnuk proses transaksi
    public void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            return;
        }

        if (balance - amount < MIN_BALANCE) {
            return;
        }
        balance -= amount;
    }
}
