package com.cratisspace.avinashbadramoni.wewriteone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cheActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_che);

        btn = (Button)findViewById(R.id.btnche);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","8985604254",null));
                intent.putExtra("sms_body", "hi, i want to complete my records! chemistry ");
                startActivity(intent);

            }
        });
    }
}
