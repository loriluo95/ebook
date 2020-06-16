package main.java.com.ebookstore.service.impl;

import main.java.com.ebookstore.dao.CartItemDao;
import main.java.com.ebookstore.model.Cart;
import main.java.com.ebookstore.model.CartItem;
import main.java.com.ebookstore.service.CartItemService;
import main.java.com.ebookstore.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService
{
    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void saveCartItem(CartItem cartItem) {cartItemDao.saveCartItem(cartItem);}

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeSavedCartItem(CartItem cartItem) {
        cartItemDao.removeSavedCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId (int productId) {
        return cartItemDao.getCartItemByProductId(productId);
    }
}
