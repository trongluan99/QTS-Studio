package com.ads.qts.ads.nativeAds;

import androidx.recyclerview.widget.RecyclerView;

import com.applovin.mediation.nativeAds.adPlacer.MaxRecyclerAdapter;

public class QtsAdAdapter {
    private AdmobRecyclerAdapter admobRecyclerAdapter;
    private MaxRecyclerAdapter maxRecyclerAdapter;

    public QtsAdAdapter(AdmobRecyclerAdapter admobRecyclerAdapter) {
        this.admobRecyclerAdapter = admobRecyclerAdapter;
    }

    public QtsAdAdapter(MaxRecyclerAdapter maxRecyclerAdapter) {
        this.maxRecyclerAdapter = maxRecyclerAdapter;
    }

    public RecyclerView.Adapter getAdapter() {
        if (admobRecyclerAdapter != null) return admobRecyclerAdapter;
        return maxRecyclerAdapter;
    }

    public void notifyItemRemoved(int pos) {
        if (maxRecyclerAdapter != null) {
            maxRecyclerAdapter.notifyItemRemoved(pos);
        }
    }

    public int getOriginalPosition(int pos) {
        if (maxRecyclerAdapter != null) {
           return maxRecyclerAdapter.getOriginalPosition(pos);
        }
        return 0;
    }

    public void loadAds() {
        if (maxRecyclerAdapter != null)
            maxRecyclerAdapter.loadAds();
    }

    public void destroy() {
        if (maxRecyclerAdapter != null)
            maxRecyclerAdapter.destroy();
    }
}