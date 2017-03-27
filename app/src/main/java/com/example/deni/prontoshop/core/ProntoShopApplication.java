package com.example.deni.prontoshop.core;

import android.app.Application;

import com.example.deni.prontoshop.core.dagger.AppComponent;
import com.example.deni.prontoshop.core.dagger.AppModule;
import com.example.deni.prontoshop.core.dagger.DaggerAppComponent;

/**
 * Created by deni on 27/03/2017.
 */

public class ProntoShopApplication extends Application{

    private static AppComponent appComponent;
    private static ProntoShopApplication instance = new ProntoShopApplication();

    public static ProntoShopApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        getAppComponent();
    }

    public AppComponent getAppComponent() {
        if (appComponent == null){
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return appComponent;
    }
}
