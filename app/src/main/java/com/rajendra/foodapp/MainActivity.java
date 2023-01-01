package com.rajendra.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rajendra.foodapp.model.Dbuser;
import com.rajendra.foodapp.model.User;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_activity);

        Button loginButton = (Button) findViewById(R.id.sendForgotPassword); // Login button
        TextView createAccountLink = (TextView) findViewById(R.id.backToLoginLink); // Login button
        TextView forgotPasswordLink = (TextView) findViewById(R.id.forgot_password_link) ; // forgot password Link
        final TextView erroMessagetext = (TextView) findViewById(R.id.errorMessage);
        createAccountLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHomePage = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intentHomePage);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get the values from inputs
                EditText phoneNumberValue = (EditText) findViewById(R.id.firstNameValueSignUp);
                EditText passwordValue = (EditText) findViewById(R.id.passwordValueSIgnup);
                // validity for loggin in
                Boolean valid = Boolean.TRUE;
                // Create a new user
                if(phoneNumberValue.getText().toString().matches("")){
                    erroMessagetext.setText("Svp donner le numéro de téléphone");
                    valid=Boolean.FALSE;
                }else if (passwordValue.getText().toString().matches("")){
                    erroMessagetext.setText("SVp donner le mot de passe");
                    valid=Boolean.FALSE;
                }else{
                    valid=Boolean.TRUE;
                }
                if(valid){

                    Dbuser dbUser = new Dbuser(getApplicationContext());
                    dbUser.open();
                    int res = dbUser.getUserWithlog(phoneNumberValue.getText().toString(),passwordValue.getText().toString());

                    //dbUser.close();
                    if(res>0){
                        phoneNumberValue.setText("");
                        passwordValue.setText("");
                        Intent intentSignUpActivity = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intentSignUpActivity);
                        finish();
                    }else{
                        erroMessagetext.setText("Numéro de téléphone ou mot de passe incoorect");
                    }
                }
            }
        });
        forgotPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentForgotPassword = new Intent(MainActivity.this,ForgotPassword.class);
                startActivity(intentForgotPassword);
            }
        });
    }

}
