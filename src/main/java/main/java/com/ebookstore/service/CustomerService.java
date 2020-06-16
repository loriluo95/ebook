package main.java.com.ebookstore.service;

import main.java.com.ebookstore.model.Customer;

import java.util.List;

public interface CustomerService
{
    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    void editCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

}
