package util;

import error.ValidationException;
import model.User;
import model.Customer;

public class ValidationUtil {

    // Validasi User (login dan register)
    public static void validate(User user)
            throws ValidationException, NullPointerException {
        if (user == null) {
            throw new NullPointerException("User is null");
        }
        
        if (user.getUsername() == null) {
            throw new NullPointerException("Username is null");
        } else if (user.getUsername().isBlank()) {
            throw new ValidationException("Username tidak boleh kosong");
        }

        if (user.getPassword() == null) {
            throw new NullPointerException("Password is null");
        } 
        else if (user.getPassword().isBlank()) {
            throw new ValidationException("Password tidak boleh kosong");
        }
    }

    // Validasi Customer (Register)
    public static void validate(Customer customer)
            throws ValidationException, NullPointerException {

        if (customer == null) {
            throw new NullPointerException("Customer is null");
        }

        if (customer.getName() == null || customer.getName().isBlank()) {
            throw new ValidationException("Nama tidak boleh kosong");
        }

        if (customer.getPhone() == null || customer.getPhone().isBlank()) {
            throw new ValidationException("No. Handphone tidak boleh kosong");
        }

        if (customer.getEmail() == null || customer.getEmail().isBlank()) {
            throw new ValidationException("Email tidak boleh kosong");
        }

        if (customer.getTier() == null || customer.getTier().isBlank()) {
            throw new ValidationException("Tier belum dipilih");
        }
    }
}
