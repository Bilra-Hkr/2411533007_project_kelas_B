package DAO;

import confg.Database;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {

    private Connection conn;

    public TransactionDao() {
        conn = Database.koneksi();
    }

    // masukan riwayat transaksi
    public boolean insert(Transaction trx) {
        String sql = "INSERT INTO transactions "
                   + "(account_number, type, amount, transaction_date) "
                   + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, trx.getAccountNumber());
            ps.setString(2, trx.getType());
            ps.setDouble(3, trx.getAmount());
            ps.setTimestamp(4, Timestamp.valueOf(trx.getTransactionDate()));
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // transaksi berdasarkan rekening
    public List<Transaction> getByAccountNumber(String accountNumber) {
        List<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM transactions WHERE account_number = ? "
                   + "ORDER BY transaction_date DESC";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaction trx = new Transaction(
                    rs.getInt("transaction_id"),
                    rs.getString("account_number"),
                    rs.getString("type"),
                    rs.getDouble("amount"),
                    rs.getTimestamp("transaction_date").toLocalDateTime()
                );
                list.add(trx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
