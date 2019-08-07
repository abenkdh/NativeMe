package com.google.android.ads.nativetemplates;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LoadRecycler {
    public static RecyclerView.LayoutManager initializing(Context context, final RecyclerView.Adapter adapter, int columns){
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(context, columns);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getItemViewType(position)) {
                    case 0:
                        return 1;
                    case 1:
                        return gridLayoutManager.getSpanCount();
                    default:
                        return -1;
                }
            }
        });
        return gridLayoutManager;
    }
}
