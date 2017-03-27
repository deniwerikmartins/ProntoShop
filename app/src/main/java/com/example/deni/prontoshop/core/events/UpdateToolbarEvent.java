package com.example.deni.prontoshop.core.events;

import com.example.deni.prontoshop.model.LineItem;

import java.util.List;

/**
 * Created by deni on 27/03/2017.
 */

public class UpdateToolbarEvent {
    private final List<LineItem> mLineItems;

    public UpdateToolbarEvent(List<LineItem> mLineItems) {
        this.mLineItems = mLineItems;
    }

    public List<LineItem> getmLineItems() {
        return mLineItems;
    }
}
