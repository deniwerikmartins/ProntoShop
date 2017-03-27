package com.example.deni.prontoshop.ui.customerlist;

import com.example.deni.prontoshop.core.listeners.OnDataBaseOperationCompleteListener;
import com.example.deni.prontoshop.model.Customer;

import java.util.List;

/**
 * Created by deni on 27/03/2017.
 */

public interface CustomerListContract {

    public interface View{
        void showCustomers(List<Customer> customers);
        void showAddCustomerForm();
        void showDeleteCustomerPrompt(Customer customer);
        void showEditCustomerForm(Customer customer);
        void showEmptyText();
        void hideEmptyText();
        void showMessage(String message);
    }

    public interface Actions{
        void loadCustomer();
        Customer getCustomer(long id);
        void onCustomerSelected(Customer customer);
        void ondAddCustomerButtonClicked();
        void addCustomer(Customer customer);
        void onDeleteCustomerButtonClicked(Customer customer);
        void deleteCustomer(Customer customer);
        void onEditCustomerButtonClicked(Customer customer);
        void updateCustomer(Customer customer);
    }

    public interface Repository{
        List<Customer> getAllCustomers();
        Customer getCustomerById(long id);
        void onDeleteCustomer(Customer customer, OnDataBaseOperationCompleteListener listener);
        void addCustomer(Customer customer, OnDataBaseOperationCompleteListener listener);
        void updatedCustomer(Customer customer, OnDataBaseOperationCompleteListener listener);
    }
}
