package com.example.deni.prontoshop.ui.checkout;

import com.example.deni.prontoshop.common.ShoppingCart;
import com.example.deni.prontoshop.core.listeners.OnDataBaseOperationCompleteListener;
import com.example.deni.prontoshop.model.LineItem;
import com.example.deni.prontoshop.model.Transaction;

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
        mView.showConfirmCheckout();
    }

    @Override
    public void onDeleteItemButtonCLicked(LineItem item) {
        mCart.removeItemFromCart(item);
        loadLineItems();
    }

    @Override
    public void checkout() {
        //Ensure e customer is selected
        if (mCart.getShoppingCart() == null || mCart.getShoppingCart().size() == 0){
            mView.showMessage("Cart is empty");
            return;
        }

        if (mCart.getSelectedCustomer() == null || mCart.getSelectedCustomer().getId() == 0){
            mView.showMessage("No Customer is selected");
            return;
        }

        Transaction transaction = new Transaction();
        transaction.setCustomerId(mCart.getSelectedCustomer().getId());
        transaction.setLineItens(mCart.getShoppingCart());
        transaction.setTaxAmount(tax);
        transaction.setSubTotalAmount(subTotal);
        transaction.setTotalAmount(total);
        transaction.setPaymentType(selectedPaymentType);
        transaction.setPaid(paid);
        mRepository.saveTransaction(transaction, this);
    }

    @Override
    public void onClearButtonClicked() {
        mView.showConfirmationClearCart();
    }

    @Override
    public void clearShoppingCart() {
        mCart.clearAllItemsFromCart();
        loadLineItems();
    }

    @Override
    public void setPaymentType(String paymentType) {
        selectedPaymentType = paymentType;
    }

    @Override
    public void markAsPaid(boolean paid) {
        this.paid = paid;
    }

    @Override
    public void onItemQuantityChanged(LineItem item, int qty) {
        mCart.updateItemQty(item, qty);
    }

    @Override
    public void onDatabaseOperationFailed(String error) {
        mView.showMessage("Error message: " + error);
    }

    @Override
    public void onDatabaseOperationSucceded(String message) {
        mView.showMessage(message);
    }
}
