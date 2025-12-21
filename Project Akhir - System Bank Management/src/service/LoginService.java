package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import confg.Database;
import model.User;

public class LoginService {

    public boolean authenticate(User user) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            Connection conn = Database.koneksi();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
