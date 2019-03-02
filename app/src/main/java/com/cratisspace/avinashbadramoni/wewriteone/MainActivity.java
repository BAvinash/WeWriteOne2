package com.cratisspace.avinashbadramoni.wewriteone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.firebase.auth.FirebaseAuth;
import com.makeramen.roundedimageview.RoundedImageView;


public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {


    TextView txtinterView ,mypoints,earnpointsbtn;
    private FirebaseAuth mAuth;
    ImageButton scratch,support,anyrecord;
    int points = 0;
    private RewardedVideoAd mRewardedVideoAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       MobileAds.initialize(getApplicationContext() , "ca-app-pub-4975126147472271~6437478705");


        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);


        scratch = (ImageButton) findViewById(R.id.scratchcard);
      //  support = (ImageButton)findViewById(R.id.support);
        anyrecord = (ImageButton)findViewById(R.id.anyRecord);
        anyrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AnyRecordActivity.class);
                startActivity(intent);
            }
        });

        scratch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "To get Scratch card Earn 100 Points By Clicking Earn Points ", Toast.LENGTH_SHORT).show();

                if (points == 1000){
                    Intent intent = new Intent(MainActivity.this,ScratchCardActivity.class);
                    startActivity(intent);
                   mypointsaftercoinsclicked();

                }


            }
        });

        mRewardedVideoAd.setRewardedVideoAdListener(this);


        txtinterView = (TextView)findViewById(R.id.interView);
        earnpointsbtn = (TextView)findViewById(R.id.earnpoints);
        mypoints = (TextView)findViewById(R.id.mypoints);


        mAuth = FirebaseAuth.getInstance();
        loadRewardedVideoAd();

        mypoints.setText("My Points:" + points);
        interViewAll();
        earnpointsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "opening", Toast.LENGTH_SHORT).show();

                if (mRewardedVideoAd.isLoaded()){
                    mRewardedVideoAd.show();
                }
            }
        });






    }

    private void mypointsaftercoinsclicked() {
        mypoints.setText(0);
    }

    private void loadRewardedVideoAd() {
        if (!mRewardedVideoAd.isLoaded()){
            mRewardedVideoAd.loadAd("ca-app-pub-4975126147472271/7100008432",new AdRequest.Builder().build());

        }
    }







    private void interViewAll() {


        txtinterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,InterShowCaseActivity.class);
                startActivity(intent);

            }
        });






    }

    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        points = points + 1;
        mypoints.setText("My Points:" + points);

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }
    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }
}
