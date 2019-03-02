package com.cratisspace.avinashbadramoni.wewriteone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Manifest;

public class AnyRecordActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;

    EditText name,mobile,record,college;
    Button send;
    TextView txt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_any_record);




        name = (EditText)findViewById(R.id.input_name);
        mobile =(EditText)findViewById(R.id.input_mobile);
        record = (EditText)findViewById(R.id.input_record);
        college = (EditText)findViewById(R.id.input_college);
        send = (Button)findViewById(R.id.btn_login);
        txt = (TextView) findViewById(R.id.number);
      send.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String newname = name.getText().toString();
              String newmobile = mobile.getText().toString();
              String newrecord = record.getText().toString();
              String newcollege = college.getText().toString();


              if (TextUtils.isEmpty(newname) && TextUtils.isEmpty(newmobile)){

                  Toast.makeText(AnyRecordActivity.this, "Please enter info", Toast.LENGTH_SHORT).show();
              }

              else if (TextUtils.isEmpty(newrecord) && TextUtils.isEmpty(newcollege)){

                  Toast.makeText(AnyRecordActivity.this, "Please enter info", Toast.LENGTH_SHORT).show();
              }

              else {

                  Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","8985604254",null));
                  intent.putExtra("sms_body", "Name:"+"  "+ newname +",Mobile Number:"+"  "+ newmobile + ",Record:"+"  "+ newrecord +",College:"+"  "+ newcollege);
                  startActivity(intent);
                  }


          }
      });



    }




}









