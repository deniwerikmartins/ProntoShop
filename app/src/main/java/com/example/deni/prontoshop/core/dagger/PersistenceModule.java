package com.example.deni.prontoshop.core.dagger;

import android.content.Context;

import com.example.deni.prontoshop.model.Product;
import com.example.deni.prontoshop.ui.customerlist.CustomerListContract;
import com.example.deni.prontoshop.ui.customerlist.CustomerListInMemoryRepository;
import com.example.deni.prontoshop.ui.productlist.ProductInMemoryRepository;
import com.example.deni.prontoshop.ui.productlist.ProductListContract;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by RedBlood on 28/03/2017.
 */
@Module
public class PersistenceModule {

    @Provides
    @Singleton
    public ProductListContract.Repository providesProductRepository(Context context){
        return new ProductInMemoryRepository();
    }

    @Provides
    @Singleton
    public CustomerListContract.Repository providesCustomerRepository(Context context){
        return new CustomerListInMemoryRepository();
    }


}
