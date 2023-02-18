package com.rajapps.quicknotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rajapps.quicknotes.ads.Admob;
import com.rajapps.quicknotes.ads.AdsUnit;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        getAds();

    }


    private void getAds(){

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("ads");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String app_id = snapshot.child("id").getValue(String.class);
                String banner = snapshot.child("banner").getValue(String.class);
                String interstitial = snapshot.child("interstitial").getValue(String.class);

                AdsUnit.appId=app_id;
                AdsUnit.banner = banner;
                AdsUnit.interstitial = interstitial;

                // app id change
                try {
                    ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
                    Bundle bundle = applicationInfo.metaData;
                    applicationInfo.metaData.putString("com.google.android.gms.ads.APPLICATION_ID",AdsUnit.appId);
                    String apiKey = bundle.getString("com.google.android.gms.ads.APPLICATION_ID");
                    Log.d("AppID", "The saved id is " + AdsUnit.appId);
                    Log.d("AppID", "The saved id is " + apiKey);

                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();


                } catch (NullPointerException e) {
                    e.printStackTrace();


                }

                //startActivity(new Intent(SplashActivity.this,MainActivity.class));
               // finish();
                check();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                check();
            }
        });

    }

    // check()
    private void check(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if(currentUser==null){
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                }else{
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
                finish();
            }
        },1000);
    }

}



/* ........................      old code below  ( ads without firebase)..............................................
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        Admob.loadInt(SplashActivity.this); // loading ads in very first activity



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
                if(currentUser==null){
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                }else{
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
                finish();
            }
        },1000);

    }
}


 */