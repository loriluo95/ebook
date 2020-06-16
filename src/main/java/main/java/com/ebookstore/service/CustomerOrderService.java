package main.java.com.ebookstore.service;

import main.java.com.ebookstore.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderService
{
    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);

}
