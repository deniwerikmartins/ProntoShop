package com.example.deni.prontoshop.core.listeners;

/**
 * Created by deni on 27/03/2017.
 */

public interface OnDataBaseOperationCompleteListener {

    void onDatabaseOperationFailed(String error);
    void onDatabaseOperationSucceded(String message);

}
