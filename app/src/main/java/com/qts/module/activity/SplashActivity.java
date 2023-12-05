package com.qts.module.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ads.qts.ads.QtsAd;
import com.ads.qts.ads.QtsAdCallback;
import com.ads.qts.ads.wrapper.ApAdError;
import com.qts.module.BuildConfig;
import com.qts.module.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        QtsAd.getInstance().loadSplashInterstitialAds(SplashActivity.this, BuildConfig.ad_appopen_resume, 5000, 25000, new QtsAdCallback() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startMain();
            }

            @Override
            public void onAdFailedToLoad(@Nullable ApAdError adError) {
                super.onAdFailedToLoad(adError);
                startMain();
            }

            @Override
            public void onAdFailedToShow(@Nullable ApAdError adError) {
                super.onAdFailedToShow(adError);
                startMain();
            }
        }, null);
    }

    private void startMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}