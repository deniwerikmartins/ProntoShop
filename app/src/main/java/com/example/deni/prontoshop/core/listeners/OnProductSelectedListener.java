package com.example.deni.prontoshop.core.listeners;

import com.example.deni.prontoshop.model.Product;

/**
 * Created by deni on 22/03/2017.
 */

public interface OnProductSelectedListener {

    void onSelectProduct(Product selectedProduct);
    void onLongClickProduct(Product clickedProduct);
}
