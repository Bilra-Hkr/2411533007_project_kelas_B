package DAO;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import model.Layanan;

public class LayananRepo {
    Connection connection;
    String select = "SELECT * FROM layanan";

    public LayananRepo(Connection conn) {
        this.connection = conn;
    }

    // CREATE
    public void save(Layanan layanan) {
        try {
            String sql = "INSERT INTO layanan(id, nama, harga) VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, layanan.getId());
            ps.setString(2, layanan.getNama());
            ps.setDouble(3, layanan.getHarga());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(LayananRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // READ
    public List<Layanan> show() {
        List<Layanan> list = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Layanan l = new Layanan();
                l.setId(rs.getString("id"));
                l.setNama(rs.getString("nama"));
                l.setHarga(rs.getDouble("harga"));
                list.add(l);
            }
        } catch (SQLException e) {
            Logger.getLogger(LayananRepo.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // UPDATE
    public void update(Layanan layanan) {
        try {
            String sql = "UPDATE layanan SET nama=?, harga=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, layanan.getNama());
            ps.setDouble(2, layanan.getHarga());
            ps.setString(3, layanan.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(LayananRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // DELETE
    public void delete(String id) {
        try {
            String sql = "DELETE FROM layanan WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(LayananRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

