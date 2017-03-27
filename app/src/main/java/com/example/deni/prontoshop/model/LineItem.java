package com.example.deni.prontoshop.model;

/**
 * Created by deni on 20/03/2017.
 */

public class LineItem extends Product{
    private int quantity;

    public LineItem(Product product, int quantity) {
        super(product);
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSumPrice(){
        return getSalePrice() * quantity;
    }
}
