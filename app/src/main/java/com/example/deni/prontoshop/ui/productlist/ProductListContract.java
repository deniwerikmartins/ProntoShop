package com.example.deni.prontoshop.ui.productlist;

import com.example.deni.prontoshop.core.listeners.OnDataBaseOperationCompleteListener;
import com.example.deni.prontoshop.model.Category;
import com.example.deni.prontoshop.model.Product;

import java.util.List;

/**
 * Created by deni on 27/03/2017.
 */

public interface ProductListContract {

    public interface View {
        void showProducts(List<Product> products);

        void showAddProductForm();

        void showEditProductForm(Product product);

        void showDeleteProductPrompt(Product product);

        void showGoogleSearch(Product product);

        void showEmptyText();

        void hideEmptyText();

        void showMessage(String message);
    }

    public interface Actions {
        void loadProducts();

        void onAddProductButtonClicked();

        void onAddToCartButtonClicked(Product product);

        Product getProduct(long id);

        void addProduct(Product product);

        void onDeleteProductButtonClicked(Product product);

        void deleteProduct(Product product);

        void onEditProductButtonClicked(Product product);

        void uptadeProduct(Product product);

        void onGoogleSearchButtonClicked(Product product);

    }

    public interface Repository {
        List<Product> getAllProducts();
        Product getProductById(long id);
        void deleteProduct(Product product, OnDataBaseOperationCompleteListener listener);
        void addProduct(Product product, OnDataBaseOperationCompleteListener listener);
        void updateProduct(Product product, OnDataBaseOperationCompleteListener listener);
        List<Category> getAllCategories();
    }

}
