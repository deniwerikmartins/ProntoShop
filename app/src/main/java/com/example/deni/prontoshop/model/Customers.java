package com.example.deni.prontoshop.model;

/**
 * Created by deni on 20/03/2017.
 */

public class Customers {
    private long id;
    private String customerName;
    private String emailAdress;
    private String phoneNumber;
    private String profileImagePath;
    private String streetAdress;
    private String streetAdress2;
    private String city;
    private String state;
    private String postalCode;
    private String note;
    private long dateAdded;
    private long dateOfLastTransaction;

    public Customers() {
        id = 0;
        customerName = "";
        emailAdress = "";
        phoneNumber = "";
        profileImagePath = "empty";
        streetAdress = "";
        streetAdress2 = "";
        city = "";
        state = "";
        postalCode = "";
        note = "";
        dateAdded = 0L;
        dateOfLastTransaction = 0L;
    }
}
