package main.java.com.ebookstore.dao;


import main.java.com.ebookstore.model.Cart;
import main.java.com.ebookstore.model.SavedItems;

import java.io.IOException;

public interface CartDao
{
    Cart getCartById (int cartId);

    SavedItems getSavedItemsByProductId (int productId);

    Cart validate(int cartId) throws IOException;

    //SavedItems validateSavedItems(int savedItemsId) throws IOException;

    void update(Cart cart);

    void updateSavedItems(SavedItems savedItems);

    void removeSavedCartItem (SavedItems savedItems);
}
