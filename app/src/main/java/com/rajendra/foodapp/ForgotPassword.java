package com.rajendra.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class ForgotPassword extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);

        Button sendEmailButton = (Button) findViewById(R.id.sendForgotPassword);
        TextView backToLogin = (TextView) findViewById(R.id.backToLoginLink);
        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToLoginActivity = new Intent(ForgotPassword.this, MainActivity.class);
                startActivity(intentToLoginActivity);
            }
        });

        backToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToLoginActivity = new Intent(ForgotPassword.this, MainActivity.class);
                startActivity(intentToLoginActivity);
            }
        });
    }

}
