package com.example.deni.prontoshop.ui.checkout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.deni.prontoshop.R;
import com.example.deni.prontoshop.core.listeners.CartActionsListener;
import com.example.deni.prontoshop.model.LineItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckoutFragment extends Fragment implements CartActionsListener{

    private View mRootView;
    private CheckoutApapter mAdapter;

    @BindView(R.id.checkout_list_recyclerview) RecyclerView mRecyclerView;
    @BindView(R.id.empty_text) TextView mEmptyTextView;
    @BindView(R.id.clear_cart_button) Button mClearButton;
    @BindView(R.id.checkout_cart_button) Button mCheckoutButton;
    @BindView(R.id.text_view_sub_total) TextView mSubTotalTextView;
    @BindView(R.id.text_view_total) TextView mTotalTextView;
    @BindView(R.id.text_view_tax) TextView mTotalTaxValue;
    @BindView(R.id.radio_group_payment_type) RadioGroup mRadioGroup;

    public CheckoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_checkout, container, false);
        ButterKnife.bind(this, mRootView);

        //Setup Adapter
        List<LineItem> tempItens = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        mAdapter = new CheckoutApapter(tempItens, getContext(), this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        if (tempItens.size() < 1){
            showEmptyTextMessage();
        } else {
            hideEmptyTextMessage();
        }


        return mRootView;
    }

    private void hideEmptyTextMessage() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mEmptyTextView.setVisibility(View.GONE);
    }

    private void showEmptyTextMessage() {
        mRecyclerView.setVisibility(View.GONE);
        mEmptyTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemDeleted(LineItem lineItem) {

    }

    @Override
    public void onItemQtyChanged(LineItem lineItem, int qty) {

    }
}
