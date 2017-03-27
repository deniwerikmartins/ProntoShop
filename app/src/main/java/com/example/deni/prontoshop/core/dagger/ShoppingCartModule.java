package com.example.deni.prontoshop.core.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.deni.prontoshop.common.ShoppingCart;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by deni on 27/03/2017.
 */
@Module
public class ShoppingCartModule {

    @Provides
    @Singleton
    public SharedPreferences providesSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    public ShoppingCart providesShoppingCart(SharedPreferences preferences){
        return new ShoppingCart(preferences);
    }

}
