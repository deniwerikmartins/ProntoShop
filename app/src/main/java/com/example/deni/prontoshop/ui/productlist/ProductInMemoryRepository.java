package com.example.deni.prontoshop.ui.productlist;

import com.example.deni.prontoshop.core.listeners.OnDataBaseOperationCompleteListener;
import com.example.deni.prontoshop.data.SampleProductData;
import com.example.deni.prontoshop.model.Category;
import com.example.deni.prontoshop.model.Product;

import java.util.List;

/**
 * Created by RedBlood on 28/03/2017.
 */

public class ProductInMemoryRepository implements ProductListContract.Repository {

    public ProductInMemoryRepository(){}

    @Override
    public List<Product> getAllProducts() {
        return SampleProductData.getSampleProducts();
    }

    @Override
    public Product getProductById(long id) {
        return null;
    }

    @Override
    public void deleteProduct(Product product, OnDataBaseOperationCompleteListener listener) {

    }

    @Override
    public void addProduct(Product product, OnDataBaseOperationCompleteListener listener) {

    }

    @Override
    public void updateProduct(Product product, OnDataBaseOperationCompleteListener listener) {

    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }
}
