package com.example.deni.prontoshop.ui.checkout;

import com.example.deni.prontoshop.model.LineItem;
import com.example.deni.prontoshop.model.Transaction;

import java.util.List;

/**
 * Created by deni on 27/03/2017.
 */

public interface CheckoutContract {

    public interface View{
        void showLineItem(List<LineItem> items);
        void showEmptyText();
        void showCartTotals(double tax, double subTotal, double total);
        void showConfirmCheckout();
        void showConfirmationClearCart();
        void hideText();
        void showMessage(String message);

    }

    public interface Actions{
        void loadLineItems();
        void onCheckoutButtonClicked();
        void onDeleteItemButtonCLicked(LineItem item);
        void checkout();
        void onClearButtonClicked();
        void clearShoppingCart();
        void setPaymentType(String paymentType);
        void markAsPaid(boolean paid);
        void onItemQuantityChanged(LineItem item, int qty);
    }

    public interface Repository{
        List<LineItem> getAllLineItems();
        void saveTransaction(Transaction transaction);
        void updateTransaction(Transaction transaction);
    }
}
