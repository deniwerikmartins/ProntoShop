package com.example.deni.prontoshop.common;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.deni.prontoshop.model.Customer;
import com.example.deni.prontoshop.model.LineItem;
import com.example.deni.prontoshop.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deni on 20/03/2017.
 */

public class ShoppingCart implements ShoppingCartContract{

    private List<LineItem> shoppingCart;
    private Customer selectedCustomer;
    private final SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final static String LOG_TAG = ShoppingCart.class.getSimpleName();
    private static boolean DEBUG = true;

    public ShoppingCart(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        initShoppingCart();
    }

    private void initShoppingCart() {
        shoppingCart = new ArrayList<>();
        selectedCustomer = new Customer();
        Gson gson = new Gson();

        //check if there are items saved to the Shared Preferences
        if (sharedPreferences.getBoolean(Constants.OPEN_CART_EXISTS, false)){
            String serializedCartItems = sharedPreferences.getString(Constants.SERIALIZED_CART_ITEMS, "");
            if (DEBUG){
                Log.d(LOG_TAG, "Serializing Cart Items: " + serializedCartItems);
            }

            String serializedCustomer = sharedPreferences.getString(Constants.SERIALIZED_COSTUMER, "");
            if (!serializedCartItems.equals("")){
                shoppingCart = gson.<ArrayList<LineItem>>fromJson(serializedCartItems,
                        new TypeToken<ArrayList<LineItem>>(){}.getType());
            }

            if (!serializedCustomer.equals("")){
                selectedCustomer = gson.fromJson(serializedCustomer, Customer.class);
            }
        }
    }

    public void saveCartToPreferences(){
        if (shoppingCart != null){
            Gson gson = new Gson();
            String serializedItems = gson.toJson(shoppingCart);
            if (DEBUG){
                Log.d(LOG_TAG, "Saving Serialized Cart Items: " + serializedItems);
            }

            String serializedCustomer = gson.toJson(selectedCustomer);
            if (DEBUG){
                Log.d(LOG_TAG, "Saving Serialized Costumer Items: " + serializedCustomer);
            }

            editor.putString(Constants.SERIALIZED_CART_ITEMS, serializedItems).commit();
            editor.putString(Constants.SERIALIZED_COSTUMER, serializedCustomer).commit();
            editor.putBoolean(Constants.OPEN_CART_EXISTS, true).commit();
        }
    }


    @Override
    public void addItemToCart(LineItem item) {

    }

    @Override
    public void removeItemFromCart(LineItem item) {

    }

    @Override
    public void clearAllItemsFromCart() {

    }

    @Override
    public List<LineItem> getShoppingCart() {
        return null;
    }

    @Override
    public void setCustomer(Customer customer) {

    }

    @Override
    public void updateItemQty(LineItem item, int qty) {

    }

    @Override
    public Customer getSelectedCustomer() {
        return null;
    }

    @Override
    public void completeCheckout() {

    }
}
