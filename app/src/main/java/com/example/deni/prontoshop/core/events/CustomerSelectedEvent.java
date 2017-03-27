package com.example.deni.prontoshop.core.events;

import com.example.deni.prontoshop.model.Customer;

/**
 * Created by deni on 27/03/2017.
 */

public class CustomerSelectedEvent {
    private final Customer selectedCustomer;
    private final boolean clearCustomer;

    public CustomerSelectedEvent(Customer selectedCustomer, boolean clearCustomer) {
        this.selectedCustomer = selectedCustomer;
        this.clearCustomer = clearCustomer;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public boolean isClearCustomer() {
        return clearCustomer;
    }
}
