package com.cratisspace.avinashbadramoni.wewriteone;

import android.content.Intent;
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

public class SignupActivity extends AppCompatActivity {


    TextView signintxt;

    EditText signupemail,signuppassword;
    ImageView signupbtn;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();


        signintxt = (TextView)findViewById(R.id.signintxt);


        signupemail = (EditText)findViewById(R.id.signupemail);
        signuppassword = (EditText)findViewById(R.id.signuppassword);
        signupbtn = (ImageView)findViewById(R.id.signupbtn);

        signintxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignupActivity.this,LoginScreenActivity.class);
                startActivity(intent);


            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CreateNewAccount();
            }
        } );


    }




    private void CreateNewAccount() {

        String email = signupemail.getText().toString();
        String password = signuppassword.getText().toString();

        if (TextUtils.isEmpty(email)){

            Toast.makeText(this, "Please enter your email....", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(password)){

            Toast.makeText(this, "Please enter your password....", Toast.LENGTH_SHORT).show();
        }
        else {

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){

                        Toast.makeText(SignupActivity.this, "Login Successful...", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignupActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(SignupActivity.this, "Login Faild...", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }


    }
}
