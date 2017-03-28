package com.example.deni.prontoshop.ui.transaction;

import com.example.deni.prontoshop.core.listeners.OnDataBaseOperationCompleteListener;
import com.example.deni.prontoshop.model.Customer;
import com.example.deni.prontoshop.model.Transaction;

import java.util.List;

/**
 * Created by RedBlood on 28/03/2017.
 */

public interface TransactionContract {
    public interface View{
        void showTransaction(List<Transaction> transactions);
        void showEmptyText();
        void hideEmptyText();
        void showConfirmDeletePrompt(Transaction transaction);
        void showMessage(String message);
    }

    public interface Actions{
        void loadTransaction();
        void onDeleteItemButtonClicked(Transaction transaction);
        void editTransaciton(Transaction transaction);
        void deleteTransaction(Transaction transaction);
        Customer getCustomerById(long id);
    }

    public interface Repository{
        List<Transaction> getAllTransactions();
        void updteTransaction(Transaction transaction, OnDataBaseOperationCompleteListener listener);
        Transaction getTransactionById(long id);
        void deleteTransaction(long id, OnDataBaseOperationCompleteListener listener);
    }
}
