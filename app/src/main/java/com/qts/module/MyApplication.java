package com.qts.module;

import com.ads.qts.ads.QtsAd;
import com.ads.qts.config.AdjustConfig;
import com.ads.qts.config.AppsflyerConfig;
import com.ads.qts.config.QtsAdConfig;
import com.ads.qts.application.AdsMultiDexApplication;
import com.ads.qts.applovin.AppLovin;
import com.ads.qts.applovin.AppOpenMax;
import com.ads.qts.billing.AppPurchase;
import com.ads.qts.admob.Admob;
import com.ads.qts.admob.AppOpenManager;
import com.qts.module.activity.MainActivity;
import com.qts.module.activity.SplashActivity;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends AdsMultiDexApplication {
    private final String APPSFLYER_TOKEN = "";
    private final String ADJUST_TOKEN = "";
    private final String EVENT_PURCHASE_ADJUST = "";
    private final String EVENT_AD_IMPRESSION_ADJUST = "";
    protected StorageCommon storageCommon;
    private static MyApplication context;
    public static MyApplication getApplication() {
        return context;
    }
    public StorageCommon getStorageCommon() {
        return storageCommon;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        Admob.getInstance().setNumToShowAds(0);

        storageCommon = new StorageCommon();
        initBilling();
        initAds();

    }

    private void initAds() {
        String environment = BuildConfig.env_dev ? QtsAdConfig.ENVIRONMENT_DEVELOP : QtsAdConfig.ENVIRONMENT_PRODUCTION;
        qtsAdConfig = new QtsAdConfig(this, QtsAdConfig.PROVIDER_ADMOB, environment);

        AdjustConfig adjustConfig = new AdjustConfig(true,ADJUST_TOKEN);
        adjustConfig.setEventAdImpression(EVENT_AD_IMPRESSION_ADJUST);
        adjustConfig.setEventNamePurchase(EVENT_PURCHASE_ADJUST);
        qtsAdConfig.setAdjustConfig(adjustConfig);
        qtsAdConfig.setIdAdResume(BuildConfig.ads_open_app);

        listTestDevice.add("EC25F576DA9B6CE74778B268CB87E431");
        qtsAdConfig.setListDeviceTest(listTestDevice);
        qtsAdConfig.setIntervalInterstitialAd(15);
        QtsAd.getInstance().init(this, qtsAdConfig, false);
        Admob.getInstance().setDisableAdResumeWhenClickAds(true);
        Admob.getInstance().setOpenActivityAfterShowInterAds(true);
        AppOpenManager.getInstance().disableAppResumeWithActivity(SplashActivity.class);
    }

    private void initBilling() {
        List<String> listINAPId = new ArrayList<>();
        listINAPId.add(MainActivity.PRODUCT_ID);
        List<String> listSubsId = new ArrayList<>();

        AppPurchase.getInstance().initBilling(getApplication(), listINAPId, listSubsId);
    }

}
