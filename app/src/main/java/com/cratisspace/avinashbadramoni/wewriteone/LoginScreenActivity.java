package com.cratisspace.avinashbadramoni.wewriteone;

import android.content.Intent;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreenActivity extends AppCompatActivity {


    EditText loginemail,loginpassword;
    ImageView loginbtn;
    TextView signuptxt;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mAuth = FirebaseAuth.getInstance();



        loginemail = (EditText)findViewById(R.id.emaillogin);
        loginpassword = (EditText)findViewById(R.id.loginpassword);
        loginbtn = (ImageView)findViewById(R.id.loginbtn);
        signuptxt = (TextView)findViewById(R.id.signuptxt);

        signuptxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginScreenActivity.this,SignupActivity.class);
                startActivity(intent);


            }
        });


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateNewAccount();
            }
        } );



    }

    private void CreateNewAccount() {

        String email = loginemail.getText().toString();
        String password = loginpassword.getText().toString();

        if (TextUtils.isEmpty(email)){

            Toast.makeText(this, "Please enter your email....", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)){

            Toast.makeText(this, "Please enter your password....", Toast.LENGTH_SHORT).show();
        }
        else {

              mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                  @Override
                  public void onComplete(@NonNull Task<AuthResult> task) {

                      if (task.isSuccessful()){
                          Toast.makeText(LoginScreenActivity.this, "is successful", Toast.LENGTH_SHORT).show();
                          Intent intent = new Intent(LoginScreenActivity.this,MainActivity.class);
                          startActivity(intent);
                      }
                      else {
                          Toast.makeText(LoginScreenActivity.this, "failed", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
        }


    }
}
