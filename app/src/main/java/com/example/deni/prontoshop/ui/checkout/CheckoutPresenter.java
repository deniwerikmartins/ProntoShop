package com.example.deni.prontoshop.ui.checkout;

import com.example.deni.prontoshop.common.ShoppingCart;
import com.example.deni.prontoshop.core.listeners.OnDataBaseOperationCompleteListener;
import com.example.deni.prontoshop.model.LineItem;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by deni on 27/03/2017.
 */

public class CheckoutPresenter implements CheckoutContract.Actions, OnDataBaseOperationCompleteListener {

    private final CheckoutContract.View mView;
    @Inject ShoppingCart mCart;
    @Inject CheckoutContract.Repository mRepository;

    private double subTotal = 0.0;
    private double total;
    private double tax;
    private double taxrate = 0.08;
    private String selectedPaymentType = "";
    private boolean paid = false;


    public CheckoutPresenter(CheckoutContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadLineItems() {
        List<LineItem> availableLineItems = mCart.getShoppingCart();
        calculateTotals(availableLineItems);
        if (availableLineItems != null && availableLineItems.size() > 0){
            mView.hideText();
            mView.showLineItem(availableLineItems);
        } else {
            mView.showEmptyText();
        }
    }

    private void calculateTotals(List<LineItem> availableLineItems) {
        subTotal = 0.0;
        total = 0.0;
        tax = 0.0;

        for (LineItem item:availableLineItems) {
            subTotal += item.getSumPrice();
        }

        tax = subTotal * taxrate;
        total = tax + subTotal;
        mView.showCartTotals(tax,subTotal,total);
    }

    @Override
    public void onCheckoutButtonClicked() {

    }

    @Override
    public void onDeleteItemButtonCLicked(LineItem item) {

    }

    @Override
    public void checkout() {

    }

    @Override
    public void onClearButtonClicked() {

    }

    @Override
    public void clearShoppingCart() {

    }

    @Override
    public void setPaymentType(String paymentType) {

    }

    @Override
    public void markAsPaid(boolean paid) {

    }

    @Override
    public void onItemQuantityChanged(LineItem item, int qty) {

    }

    @Override
    public void onDatabaseOperationFailed(String error) {

    }

    @Override
    public void onDatabaseOperationSucceded(String message) {

    }
}
