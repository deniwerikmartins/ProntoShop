package com.example.deni.prontoshop.common;

import com.example.deni.prontoshop.model.Customer;
import com.example.deni.prontoshop.model.LineItem;

import java.util.List;

/**
 * Created by RedBlood on 25/03/2017.
 */

public interface ShoppingCartContract {
    void addItemToCart(LineItem item);
    void removeItemFromCart(LineItem item);
    void clearAllItemsFromCart();
    List<LineItem> getShoppingCart();
    void setCustomer(Customer customer);
    void updateItemQty(LineItem item, int qty);
    Customer getSelectedCustomer();
    void completeCheckout();
}
