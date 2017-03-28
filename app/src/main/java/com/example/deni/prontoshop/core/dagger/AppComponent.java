package com.example.deni.prontoshop.core.dagger;

import com.example.deni.prontoshop.common.MainActivity;
import com.example.deni.prontoshop.common.ShoppingCart;
import com.example.deni.prontoshop.model.Transaction;
import com.example.deni.prontoshop.ui.customerlist.CustomerPresenter;
import com.example.deni.prontoshop.ui.productlist.ProductPresenter;
import com.example.deni.prontoshop.ui.transaction.TransactionPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by deni on 20/03/2017.
 */

@Singleton
@Component(
        modules = {
            AppModule.class,
            ShoppingCartModule.class,
                BusModule.class,
                PersistenceModule.class
        }
)
public interface AppComponent {

    void inject(MainActivity activity);
    void inject(ShoppingCart cart);
    void inject(ProductPresenter presenter);
    void inject(CustomerPresenter presenter);
    void inject(TransactionPresenter presenter);

}
