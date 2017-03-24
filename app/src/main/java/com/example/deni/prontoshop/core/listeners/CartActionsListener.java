package com.example.deni.prontoshop.core.listeners;

import com.example.deni.prontoshop.model.LineItem;

/**
 * Created by RedBlood on 24/03/2017.
 */

public interface CartActionsListener {

    void onItemDeleted(LineItem lineItem);
    void onItemQtyChanged(LineItem lineItem, int qty);
}
