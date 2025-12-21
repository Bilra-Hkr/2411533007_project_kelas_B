package service;

import java.util.List;

import DAO.CustomerDao;
import DAO.CustomerRepo;
import model.Customer;

public class CustomerService {

    private CustomerDao customerDao;

    public CustomerService() {
        this.customerDao = new CustomerDao();
    }

    public Customer getByUserId(int userId) {
        return customerDao.getByUserId(userId);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }
    
//    public List<Customer> getAll() {
//        return CustomerRepo.show();
//    }
}


