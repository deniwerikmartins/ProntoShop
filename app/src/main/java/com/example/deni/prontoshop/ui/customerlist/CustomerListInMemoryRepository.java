package com.example.deni.prontoshop.ui.customerlist;

import com.example.deni.prontoshop.core.listeners.OnDataBaseOperationCompleteListener;
import com.example.deni.prontoshop.data.SampleCustomerData;
import com.example.deni.prontoshop.model.Customer;

import java.util.List;

/**
 * Created by RedBlood on 28/03/2017.
 */

public class CustomerListInMemoryRepository implements CustomerListContract.Repository {



    @Override
    public List<Customer> getAllCustomers() {
        return SampleCustomerData.getCustomers();
    }

    @Override
    public Customer getCustomerById(long id) {
        return null;
    }

    @Override
    public void onDeleteCustomer(Customer customer, OnDataBaseOperationCompleteListener listener) {

    }

    @Override
    public void addCustomer(Customer customer, OnDataBaseOperationCompleteListener listener) {

    }

    @Override
    public void updatedCustomer(Customer customer, OnDataBaseOperationCompleteListener listener) {

    }
}
