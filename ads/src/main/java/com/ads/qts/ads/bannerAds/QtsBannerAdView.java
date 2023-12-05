package com.ads.qts.ads.bannerAds;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ads.qts.R;
import com.ads.qts.admob.Admob;
import com.ads.qts.ads.QtsAd;
import com.ads.qts.ads.QtsAdCallback;
import com.ads.qts.funtion.AdCallback;

public class QtsBannerAdView extends RelativeLayout {

    private String TAG = "QtsBannerAdView";

    public QtsBannerAdView(@NonNull Context context) {
        super(context);
        init();
    }

    public QtsBannerAdView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public QtsBannerAdView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    public QtsBannerAdView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.layout_banner_control, this);
    }

    public void loadBanner(Activity activity, String idBanner,String tokenAdjust) {
        loadBanner(activity, idBanner, new QtsAdCallback(), tokenAdjust);
    }

    public void loadBanner(Activity activity, String idBanner, QtsAdCallback QtsAdCallback, String tokenAdjust) {
        QtsAd.getInstance().loadBanner(activity, idBanner, QtsAdCallback, tokenAdjust);
    }

    public void loadInlineBanner(Activity activity, String idBanner, String inlineStyle, String tokenAdjust) {
        Admob.getInstance().loadInlineBanner(activity, idBanner, inlineStyle, tokenAdjust);
    }

    public void loadInlineBanner(Activity activity, String idBanner, String inlineStyle, AdCallback adCallback, String tokenAdjust) {
        Admob.getInstance().loadInlineBanner(activity, idBanner, inlineStyle, adCallback, tokenAdjust);
    }

    public void loadBannerFragment(Activity activity, String idBanner, String tokenAdjust) {
        QtsAd.getInstance().loadBannerFragment(activity, idBanner, getRootView(), tokenAdjust);
    }

    public void loadBannerFragment(Activity activity, String idBanner, AdCallback adCallback, String tokenAdjust) {
        QtsAd.getInstance().loadBannerFragment(activity, idBanner, getRootView(), adCallback, tokenAdjust);
    }

    public void loadInlineBannerFragment(Activity activity, String idBanner, String inlineStyle, String tokenAdjust) {
        Admob.getInstance().loadInlineBannerFragment(activity, idBanner, getRootView(), inlineStyle, tokenAdjust);
    }

    public void loadInlineBannerFragment(Activity activity, String idBanner, String inlineStyle, AdCallback adCallback, String tokenAdjust) {
        Admob.getInstance().loadInlineBannerFragment(activity, idBanner, getRootView(), inlineStyle, adCallback, tokenAdjust);
    }
}