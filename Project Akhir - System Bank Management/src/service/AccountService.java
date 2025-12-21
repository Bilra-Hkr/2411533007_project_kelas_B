package service;

import DAO.AccountDao;
import model.Account;
import model.Customer;
import model.SavingAccount;

public class AccountService {

    private AccountDao accountDao = new AccountDao();

    // Buat rekening baru
    public SavingAccount createAccount(Customer customer) {
        String accountNumber = generateAccountNumber();
        SavingAccount account = new SavingAccount(accountNumber, customer);
        accountDao.insert(account);
        return account;
    }

    public Account getAccount(Customer customer) {
        return accountDao.getByCustomerId(customer);
    }
    
    public Account getByCustomerId(int customerId) {
        return accountDao.findByCustomerId(customerId);
    }

    public boolean updateBalance(Account account) {
        return accountDao.updateBalance(account);
    }

    // generate nomor rekening
    private String generateAccountNumber() {
        return "10" + System.currentTimeMillis();
    }
}
