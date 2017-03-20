package com.example.deni.prontoshop.model;

/**
 * Created by deni on 20/03/2017.
 */

public class Category {

    private long id;
    private String categoryName;

    public Category() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
