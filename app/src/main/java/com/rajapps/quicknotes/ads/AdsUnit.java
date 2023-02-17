package com.rajapps.quicknotes.ads;

import com.google.android.gms.ads.interstitial.InterstitialAd;

public class AdsUnit {

    static InterstitialAd mInterstitialAd;
    public static boolean isAds = false;
    public static String Interstetial = "ca-app-pub-3940256099942544/1033173712"; //interstitial

    public static String BANNER="ca-app-pub-3940256099942544/6300978111"; //banner
    // Admob.setBanner(findViewById(R.id.banner),MainActivity.this); // place in java file where you want to show add

    // Admob.loadInt(SplashActivity.this); // loading ads in very first activity
}

// codes to implement interstitial ads on a button

/*
  addNoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Admob(new OnDismiss(){
                    @Override
                    public void onDismiss(){
                        // code to run

                        startActivity(new Intent(MainActivity.this,NoteDetailsActivity.class));
                        //
                    }

                }).showIntCall(MainActivity.this,true);



            }
        });


*/
