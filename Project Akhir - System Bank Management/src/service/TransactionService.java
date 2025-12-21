package service;

import DAO.AccountDao;
import DAO.TransactionDao;
import model.Account;
import model.Transaction;

public class TransactionService {
    private AccountDao accountDao = new AccountDao();
    private TransactionDao transactionDao = new TransactionDao();

    //Setor saldo
    public boolean deposit(Account account, double amount) {
        if (amount <= 0) {
            return false;
        }
        account.deposit(amount);
        accountDao.updateBalance(account);

        Transaction trans = new Transaction(
                account.getAccountNumber(),
                "DEPOSIT",
                amount
        );
        transactionDao.insert(trans);
        
        return true;
    }

    // Tarik Saldo/withdraw
    public boolean withdraw(Account account, double amount) {
        if (amount <= 0) {
            return false;
        }
        double saldoAwal = account.getBalance();
        account.withdraw(amount);

        // cek apakah saldo berubah (berhasil melakukan penarikan saldo)
        if (saldoAwal == account.getBalance()) {
            return false;
        }
        accountDao.updateBalance(account);

        Transaction trx = new Transaction(
                account.getAccountNumber(),
                "WITHDRAW",
                amount
        );
        transactionDao.insert(trx);

        return true;
    }
}
