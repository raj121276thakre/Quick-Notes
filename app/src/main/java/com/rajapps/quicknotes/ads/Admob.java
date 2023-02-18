package com.rajapps.quicknotes.ads;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class Admob {

    public static void loadAds(LinearLayout container , Context context){

            MobileAds.initialize(context, new OnInitializationCompleteListener() {
                @Override
                public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) { }
            });

            AdView adview = new AdView(context);
            adview.setAdUnitId(Pref.getPref(AdsUnit.banner,context));
            container.addView(adview);
            AdRequest adRequest= new AdRequest.Builder().build();
            adview.setAdSize(AdSize.BANNER);
            adview.loadAd(adRequest);

    }


}

//'''''''''''''''''''''''old code ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
/*
public class Admob {

    OnDismiss onDismiss;

    public Admob(OnDismiss onDismiss){
        this.onDismiss=onDismiss;
    }

    public Admob(){

    }



    public static void loadInt(Context context){


        if (AdsUnit.isAds){

            MobileAds.initialize(context, initializationStatus -> { });

            AdRequest adRequest = new AdRequest.Builder().build();

            InterstitialAd.load(context,AdsUnit.Interstetial, adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            // The mInterstitialAd reference will be null until
                            // an ad is loaded.
                           AdsUnit.mInterstitialAd = interstitialAd;

                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error
                            AdsUnit.mInterstitialAd = null;
                        }
                    });


        }// if end


    }

    public void showIntCall(Activity activity, boolean isReload){

        if (AdsUnit.mInterstitialAd != null) {
            AdsUnit.mInterstitialAd.show(activity);

            AdsUnit.mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();

                    if (isReload){
                        AdsUnit.mInterstitialAd=null;
                        Admob.loadInt(activity);
                    }

                    onDismiss.onDismiss();

                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);

                    onDismiss.onDismiss();
                }
            });



        } else {

            onDismiss.onDismiss();

        }



    }

    //  banner ads
    public static void setBanner(LinearLayout banner , Context context){
        if(AdsUnit.isAds){
            MobileAds.initialize(context, initializationStatus -> { });

            AdView adview = new AdView(context);
            banner.addView(adview);
            adview.setAdUnitId(AdsUnit.BANNER);
            adview.setAdSize(AdSize.BANNER);
            AdRequest adRequest= new AdRequest.Builder().build();
            adview.loadAd(adRequest);
        }
    }



}
*/