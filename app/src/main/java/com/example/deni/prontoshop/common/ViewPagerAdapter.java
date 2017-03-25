package com.example.deni.prontoshop.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.deni.prontoshop.ui.checkout.CheckoutFragment;
import com.example.deni.prontoshop.ui.customerlist.CustomerListFragment;
import com.example.deni.prontoshop.ui.productlist.ProductListFragment;

/**
 * Created by RedBlood on 25/03/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment selectFragment;
        switch (position){
            case 0:
                selectFragment = new ProductListFragment();
                break;
            case 1:
                selectFragment = new CustomerListFragment();
                break;
            case 2:
                selectFragment = new CheckoutFragment();
                break;
            default:
                selectFragment = new ProductListFragment();
        }
        return selectFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Products";
                break;
            case 1:
                title = "Customers";
                break;
            case 2:
                title = "Shopping Cart";
                break;
        }

        return title;
    }
}
