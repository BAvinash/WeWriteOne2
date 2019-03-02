package com.cratisspace.avinashbadramoni.wewriteone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.makeramen.roundedimageview.RoundedImageView;

public class InterShowCaseActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imgback;
    RoundedImageView img2,img3,img4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter_show_case);

        toolbar = findViewById(R.id.toolbar);
        imgback = (ImageView)findViewById(R.id.backToHome);
        img2 = (RoundedImageView)findViewById(R.id.imgch);
        img3 = (RoundedImageView)findViewById(R.id.imgbo);
        img4 = (RoundedImageView)findViewById(R.id.imgzo);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InterShowCaseActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });





        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(InterShowCaseActivity.this,cheActivity.class);
                startActivity(intent);

            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InterShowCaseActivity.this,boActivity.class);
                startActivity(intent);

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InterShowCaseActivity.this,zoActivity.class);
                startActivity(intent);

            }
        });
    }
}
