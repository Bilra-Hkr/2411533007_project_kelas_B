package DAO;

import confg.Database;
import model.Customer;
import model.CustomerBuilder;

import java.lang.System.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
 

public class CustomerRepo {
    private Connection conn;

    public CustomerRepo() {
        this.conn = Database.koneksi();
    }

    public boolean insert(Customer customer) {
        String sql = "INSERT INTO customers (name, phone, email, tier, user_id, saldo) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getTier());
            ps.setInt(5, customer.getCustomerId());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Customer getByUserId(int userId) {
        String sql = "SELECT * FROM customers WHERE user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCustomer(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Customer> getAll() {
        List<Customer> listCustomer = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                listCustomer.add(mapResultSetToCustomer(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCustomer;
    }
    
    public List<Customer> show() {
        List<Customer> list = new ArrayList<>();
        String select = "SELECT * FROM customers";

        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(select)) {
            
            while (rs.next()) {
                Customer cs = new CustomerBuilder()
                        .setCustomerId(rs.getInt("customer_id"))
                        .setName(rs.getString("name"))  
                        .setEmail(rs.getString("email"))
                        .setPhone(rs.getString("phone")) 
                        .setTier(rs.getString("tier"))
                        .build();
                list.add(cs);
            }
        } catch (SQLException e) {
//             Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    
    public boolean update(Customer c) {
        String sql = "UPDATE customers SET name=?, phone=?, email=?, tier=? WHERE customer_id=?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getTier());
            ps.setInt(5, c.getCustomerId());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(int customerId) {
        String sql = "DELETE FROM customers WHERE customer_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private Customer mapResultSetToCustomer(ResultSet rs) throws SQLException {
        return new CustomerBuilder()
                .setCustomerId(rs.getInt("customer_id"))
                .setName(rs.getString("name"))
                .setPhone(rs.getString("phone"))
                .setEmail(rs.getString("email"))
                .setTier(rs.getString("tier"))
                .build();
    }
}