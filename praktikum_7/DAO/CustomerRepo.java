package DAO;

import confg.Database;
import model.Customer;
import model.CustomerBuilder;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger; 

public class CustomerRepo implements CustomerDao {

    private static CustomerRepo instance;

    
    public static CustomerRepo getInstance() {
        if (instance == null) {
            instance = new CustomerRepo();
        }
        return instance;
    }
    
    private Connection connection;

    
    private final String insert = "INSERT INTO customer (nama, email, alamat, hp) VALUES (?, ?, ?, ?);";
    private final String select = "SELECT * FROM customer;";
    private final String delete = "DELETE FROM customer WHERE id=?;";
    private final String update = "UPDATE customer SET nama=?, email=?, alamat=?, hp=? WHERE id=?;"; 

    // Konstruktor
    public CustomerRepo() {
        connection = Database.koneksi();
    }

    // Implementasi method save
    @Override
    public void save(Customer cs) {
        try (PreparedStatement st = connection.prepareStatement(insert)) {
            
            st.setString(1, cs.getNama());
            st.setString(2, cs.getEmail());
            st.setString(3, cs.getAlamat());
            st.setString(4, cs.getNoHp()); 
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Implementasi method show
    @Override
    public List<Customer> show() {
        List<Customer> list = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(select)) {
            
            while (rs.next()) {
                Customer cs = new CustomerBuilder()
                        .setID(rs.getString("id"))
                        .setNama(rs.getString("nama"))
                        .setEmail(rs.getString("email"))
                        .setAlamat(rs.getString("alamat"))
                        .setHp(rs.getString("hp")) 
                        .build();
                list.add(cs);
            }
        } catch (SQLException e) {
             Logger.getLogger(CustomerRepo.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }


    // Implementasi method update
    @Override
    public void update(Customer cs) {
        try (PreparedStatement st = connection.prepareStatement(update)) {
            st.setString(1, cs.getNama());
            st.setString(2, cs.getEmail());
            st.setString(3, cs.getAlamat());
            st.setString(4, cs.getNoHp()); 
            st.setString(5, cs.getId()); 
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Implementasi method delete
    @Override
    public void delete(String id) {
        try (PreparedStatement st = connection.prepareStatement(delete)) {
            st.setString(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}