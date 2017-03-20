package com.example.deni.prontoshop.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by deni on 20/03/2017.
 */

public class Transaction {

    private long id;
    private long customerId;
    private double subTotalAmount;
    private double taxAmount;
    private double totalAmount;
    private boolean paid;
    private String paymentType;
    private long transactionDate;
    private long modifiedDate;

    //this property cannot be persisted
    private List<LineItem> lineItens;

    //the list of line items woll be persisted into this json
    //string before it canbe sabed to the database
    private String jsonLineItem;

    public Transaction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getSubTotalAmount() {
        return subTotalAmount;
    }

    public void setSubTotalAmount(double subTotalAmount) {
        this.subTotalAmount = subTotalAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(long transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<LineItem> getLineItens() {
        Gson gson = new Gson();
        String serializedLineItems = getJsonLineItem();
        List<LineItem> result = gson.<ArrayList<LineItem>>fromJson(serializedLineItems,
                new TypeToken<ArrayList<LineItem>>(){}.getType());
        return lineItens;
    }

    public void setLineItens(List<LineItem> lineItens) {
        Gson gson = new Gson();
        String lineItemJson = gson.toJson(lineItens);
        this.setJsonLineItem(lineItemJson);
        //this.lineItens = lineItens;
    }

    public String getJsonLineItem() {
        return jsonLineItem;
    }

    public void setJsonLineItem(String jsonLineItem) {
        this.jsonLineItem = jsonLineItem;
    }
}
