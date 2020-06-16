package main.java.com.ebookstore.service.impl;

import main.java.com.ebookstore.dao.CustomerOrderDao;
import main.java.com.ebookstore.model.Cart;
import main.java.com.ebookstore.model.CartItem;
import main.java.com.ebookstore.model.CustomerOrder;
import main.java.com.ebookstore.model.Product;
import main.java.com.ebookstore.service.CartService;
import main.java.com.ebookstore.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService
{
    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    private List<Product> bestSellers;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }


}
