package com.example.deni.prontoshop.core.listeners;

import com.example.deni.prontoshop.model.Customer;

/**
 * Created by RedBlood on 24/03/2017.
 */

public interface OnCustomerSelectedListener {
    void onSelectCustomer(Customer customer);
    void onLongClickCustomer(Customer customer);
}
