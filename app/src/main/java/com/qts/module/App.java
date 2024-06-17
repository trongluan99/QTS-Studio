package com.qts.module;

import com.ads.qts.admob.Admob;
import com.ads.qts.admob.AppOpenManager;
import com.ads.qts.ads.QtsAd;
import com.ads.qts.application.AdsMultiDexApplication;
import com.ads.qts.billing.AppPurchase;
import com.ads.qts.config.AdjustConfig;
import com.ads.qts.config.QtsAdConfig;

import java.util.ArrayList;
import java.util.List;

public class App extends AdsMultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initAds();
        initBilling();
    }

    private void initAds() {
        String environment = BuildConfig.DEBUG ? QtsAdConfig.ENVIRONMENT_DEVELOP : QtsAdConfig.ENVIRONMENT_PRODUCTION;
        mQtsAdConfig = new QtsAdConfig(this, environment);

        AdjustConfig adjustConfig = new AdjustConfig(true, getString(R.string.adjust_token));
        mQtsAdConfig.setAdjustConfig(adjustConfig);
        mQtsAdConfig.setFacebookClientToken(getString(R.string.facebook_client_token));
        mQtsAdConfig.setAdjustTokenTiktok(getString(R.string.tiktok_token));

        mQtsAdConfig.setIdAdResume("");

        QtsAd.getInstance().init(this, mQtsAdConfig);
        Admob.getInstance().setDisableAdResumeWhenClickAds(true);
        Admob.getInstance().setOpenActivityAfterShowInterAds(true);
        AppOpenManager.getInstance().disableAppResumeWithActivity(MainActivity.class);
    }

    private void initBilling() {
        List<String> listIAP = new ArrayList<>();
        listIAP.add("android.test.purchased");
        List<String> listSub = new ArrayList<>();
        AppPurchase.getInstance().initBilling(this, listIAP, listSub);
    }
}
