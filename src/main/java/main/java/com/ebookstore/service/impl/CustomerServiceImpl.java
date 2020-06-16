package main.java.com.ebookstore.service.impl;

import main.java.com.ebookstore.dao.CustomerDao;
import main.java.com.ebookstore.model.Customer;
import main.java.com.ebookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService
{

    @Autowired
    private CustomerDao customerDao;

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getCustomerByUsername(String username)
    {
        return customerDao.getCustomerByUsername(username);
    }

    public void editCustomer(Customer customer)
    {
        customerDao.editCustomer(customer);
    }

}
