package com.cratisspace.avinashbadramoni.wewriteone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScratchCardActivity extends AppCompatActivity {

    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch_card);
        txt = (TextView)findViewById(R.id.screenshot);


        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","8985604254",null));
                intent.putExtra("sms_body", "i am rewarded");
                startActivity(intent);

            }
        });
    }
}
