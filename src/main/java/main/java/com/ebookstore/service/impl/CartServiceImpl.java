package main.java.com.ebookstore.service.impl;

import main.java.com.ebookstore.dao.CartDao;
import main.java.com.ebookstore.model.Cart;
import main.java.com.ebookstore.model.SavedItems;
import main.java.com.ebookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService
{
    @Autowired
    private CartDao cartDao;

    public void update(Cart cart) {
        cartDao.update(cart);
    }

    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }

    public SavedItems getSavedItemsByProductId(int productId) {
        return cartDao.getSavedItemsByProductId(productId);
    }

    public void updateSavedItems(SavedItems savedItems) {
        cartDao.updateSavedItems(savedItems);
    }

    public void removeSavedCartItem(SavedItems savedItems) {
        cartDao.removeSavedCartItem(savedItems);
    }
}