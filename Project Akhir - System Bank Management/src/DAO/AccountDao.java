package DAO;

import confg.Database;
import model.Account;
import model.Customer;
import model.SavingAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDao {
    private Connection conn;

    public AccountDao() {
        conn = Database.koneksi();
    }

    // membuat rekening baru
    public boolean insert(Account account) {
        String sql = "INSERT INTO accounts (account_number, balance, customer_id) "
                   + "VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, account.getAccountNumber());
            ps.setDouble(2, account.getBalance());
            ps.setInt(3, account.getCustomer().getCustomerId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // mencari rekening berdasarkan id
    public Account getByCustomerId(Customer customer) {
        String sql = "SELECT * FROM accounts WHERE customer_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customer.getCustomerId());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                SavingAccount account =
                        new SavingAccount(
                                rs.getString("account_number"),
                                customer
                        );
                account.setBalance(rs.getDouble("balance"));
                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update balance(saldo)
    public boolean updateBalance(Account account) {
        String sql = "UPDATE accounts SET balance = ? WHERE account_number = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, account.getBalance());
            ps.setString(2, account.getAccountNumber());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Account findByCustomerId(int customerId) {
        String sql = "SELECT * FROM account WHERE customer_id = ?";

        try (Connection conn = Database.koneksi();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Account(
                    rs.getInt("account_id"),
                    rs.getString("account_number"),
                    rs.getDouble("balance"),
                    rs.getInt("customer_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
