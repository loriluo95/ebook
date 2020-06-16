package main.java.com.ebookstore.dao;


import main.java.com.ebookstore.model.Cart;
import main.java.com.ebookstore.model.CartItem;

public interface CartItemDao
{
    void addCartItem(CartItem cartItem);

    void saveCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeSavedCartItem (CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId (int productId);
}
