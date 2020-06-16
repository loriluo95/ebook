package main.java.com.ebookstore.service;

import main.java.com.ebookstore.model.Cart;
import main.java.com.ebookstore.model.SavedItems;

public interface CartService
{
    Cart getCartById (int cartId);

    SavedItems getSavedItemsByProductId (int productId);

    void update(Cart cart);

    void updateSavedItems(SavedItems savedItems);

    void removeSavedCartItem(SavedItems savedItems);
}
