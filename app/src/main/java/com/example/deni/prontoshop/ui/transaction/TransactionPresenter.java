package com.example.deni.prontoshop.ui.transaction;

import com.example.deni.prontoshop.core.ProntoShopApplication;
import com.example.deni.prontoshop.core.listeners.OnDataBaseOperationCompleteListener;
import com.example.deni.prontoshop.model.Customer;
import com.example.deni.prontoshop.model.Transaction;
import com.example.deni.prontoshop.ui.customerlist.CustomerListContract;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by RedBlood on 28/03/2017.
 */

public class TransactionPresenter implements TransactionContract.Actions, OnDataBaseOperationCompleteListener{

    private final TransactionContract.View mView;
    @Inject TransactionContract.Repository mRepository;
    @Inject CustomerListContract.Repository mCustomerRepository;

    public TransactionPresenter(TransactionContract.View mView) {
        this.mView = mView;
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }


    @Override
    public void loadTransaction() {
        List<Transaction> transactions = mRepository.getAllTransactions();
        if(transactions != null && transactions.size() > 0){
            mView.hideEmptyText();
            mView.showTransaction(transactions);
        } else {
            mView.showEmptyText();
        }
    }

    @Override
    public void onDeleteItemButtonClicked(Transaction transaction) {
        mView.showConfirmDeletePrompt(transaction);
    }

    @Override
    public void editTransaciton(Transaction transaction) {
        mRepository.updteTransaction(transaction, this);
    }

    @Override
    public void deleteTransaction(Transaction transaction) {
        mRepository.deleteTransaction(transaction.getId(), this);
    }

    @Override
    public Customer getCustomerById(long id) {
        return mCustomerRepository.getCustomerById(id);
    }

    @Override
    public void onDatabaseOperationFailed(String error) {
        mView.showMessage("Error: " + error);
    }

    @Override
    public void onDatabaseOperationSucceded(String message) {
        mView.showMessage(message);
    }
}
