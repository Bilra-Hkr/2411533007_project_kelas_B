package service;

import DAO.UserDao;
import DAO.CustomerDao;
import model.User;
import model.Customer;
import model.CustomerBuilder;

public class RegisterService {
    private UserDao userDao = new UserDao();
    private CustomerDao customerDao = new CustomerDao();

    public boolean register(String username, String password, String name, 
    		String phone, String email, String tier) {
        // Simpan user baru
        User user = new User(username, password);
        boolean userSaved = userDao.insert(user);
        if (!userSaved) {
            return false;
        }
        // Ambil user yang baru dibuat
        User savedUser = userDao.login(username, password);
        if (savedUser == null) {
            return false;
        }
        // Buat customer menggunakan Builder
        Customer customer = new CustomerBuilder()
                .setName(name)
                .setPhone(phone)
                .setEmail(email)
                .setTier(tier)
                .build();
        // Simpan customer
        return customerDao.insert(customer, savedUser.getUserId());
    }
    
    public boolean register(User user, Customer customer) {
        boolean userSaved = userDao.insert(user);
        if (!userSaved) {
            return false;
        }

        User savedUser = userDao.login(user.getUsername(), user.getPassword());
        if (savedUser == null) {
            return false;
        }

        return customerDao.insert(customer, savedUser.getUserId());
    }

}
