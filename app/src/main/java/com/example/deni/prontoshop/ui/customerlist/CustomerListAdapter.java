package com.example.deni.prontoshop.ui.customerlist;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.deni.prontoshop.R;
import com.example.deni.prontoshop.core.listeners.OnCustomerSelectedListener;
import com.example.deni.prontoshop.model.Customer;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by deni on 23/03/2017.
 */

public class CustomerListAdapter extends RecyclerView.Adapter<CustomerListAdapter.ViewHolder> {

    private List<Customer> mCustomers;
    private final Context mContext;
    private final OnCustomerSelectedListener mListener;
    private boolean shouldHighlightSelectedCustomer = false;
    private int selectedPosition = 0;

    public CustomerListAdapter(List<Customer> customers, Context context, OnCustomerSelectedListener listener) {
        this.mCustomers = customers;
        this.mContext = context;
        this.mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_customer_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Customer selectCustomer = mCustomers.get(position);
        holder.customerName.setText(selectCustomer.getCustomerName());
        holder.customerEmail.setText(selectCustomer.getEmailAdress());
        Picasso.with(mContext)
                .load(selectCustomer.getProfileImagePath())
                .fit()
                .placeholder(R.drawable.profile_icon)
                .into(holder.customerHeadShot);

        if (shouldHighlightSelectedCustomer){
            if (selectedPosition == position){
                holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.primary_light));
            } else {
                holder.itemView.setBackgroundColor(Color.TRANSPARENT);
            }
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }


    }

    @Override
    public int getItemCount() {
        if (mCustomers != null) {
            return mCustomers.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        @BindView(R.id.image_view_customer_head_shot) ImageView customerHeadShot;
        @BindView(R.id.text_view_customer_email) TextView customerEmail;
        @BindView(R.id.text_view_customer_name) TextView customerName;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            shouldHighlightSelectedCustomer = true;
            selectedPosition = getLayoutPosition();
            Customer selectedCustomer = mCustomers.get(selectedPosition);
            mListener.onSelectCustomer(selectedCustomer);
            notifyDataSetChanged();
        }

        @Override
        public boolean onLongClick(View v) {
            Customer selectedCustomer = mCustomers.get(selectedPosition);
            mListener.onLongClickCustomer(selectedCustomer);
            return true;
        }
    }
}
