package DAO;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import model.Pelanggan;

public class PelangganRepo {
    Connection connection;
    String select = "SELECT * FROM pelanggan";

    public PelangganRepo(Connection conn) {
        this.connection = conn;
    }

    // CREATE
    public void save(Pelanggan pelanggan) {
        try {
            String sql = "INSERT INTO pelanggan(id, nama, alamat, telepon) VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pelanggan.getId());
            ps.setString(2, pelanggan.getNama());
            ps.setString(3, pelanggan.getAlamat());
            ps.setString(4, pelanggan.getTelepon());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PelangganRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // READ
    public List<Pelanggan> show() {
        List<Pelanggan> list = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setId(rs.getString("id"));
                p.setNama(rs.getString("nama"));
                p.setAlamat(rs.getString("alamat"));
                p.setTelepon(rs.getString("telepon"));
                list.add(p);
            }
        } catch (SQLException e) {
            Logger.getLogger(PelangganRepo.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    // UPDATE
    public void update(Pelanggan pelanggan) {
        try {
            String sql = "UPDATE pelanggan SET nama=?, alamat=?, telepon=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pelanggan.getNama());
            ps.setString(2, pelanggan.getAlamat());
            ps.setString(3, pelanggan.getTelepon());
            ps.setString(4, pelanggan.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PelangganRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // DELETE
    public void delete(String id) {
        try {
            String sql = "DELETE FROM pelanggan WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(PelangganRepo.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

