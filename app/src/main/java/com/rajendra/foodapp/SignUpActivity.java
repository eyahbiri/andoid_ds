package com.rajendra.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rajendra.foodapp.model.Dbuser;
import com.rajendra.foodapp.model.User;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_activity);

        Button createAccountButton = (Button) findViewById(R.id.login_link);
        TextView alreadyHaveAccount = (TextView) findViewById(R.id.backToLoginLink);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText firstNameValue = (EditText) findViewById(R.id.firstNameValueSignUp);
                EditText lastNameValue = (EditText) findViewById(R.id.lastNameValueSignUp);
                EditText phoneNumberValue = (EditText) findViewById(R.id.phoneNumberValueSignUp);
                EditText passwordValue = (EditText) findViewById(R.id.passwordValueSIgnup);
                TextView errorMessageValue = (TextView) findViewById(R.id.errorMessageSignUp);
                Boolean valid = Boolean.FALSE;
                if(firstNameValue.getText().toString().matches("")){
                    errorMessageValue.setText("Le prénom est obligatoire");
                    valid=Boolean.FALSE;
                }else if(lastNameValue.getText().toString().matches("")){
                    errorMessageValue.setText("Le nom est obligatoire");
                    valid=Boolean.FALSE;
                }else if(phoneNumberValue.getText().toString().matches("")){
                    errorMessageValue.setText("Le numéro de télephone est obligatoire");
                    valid=Boolean.FALSE;
                }else if(passwordValue.getText().toString().matches("")){
                    errorMessageValue.setText("Le mot de passe est obligatoire");
                    valid=Boolean.FALSE;
                }else{
                    Dbuser dbUser = new Dbuser(getApplicationContext());
                    dbUser.open();
                    int res = dbUser.getUserWithlog(phoneNumberValue.getText().toString(),passwordValue.getText().toString());

                    dbUser.close();
                    if(res>0){

                        errorMessageValue.setText("Cette utilisateur exist déja");
                    }else{
                        firstNameValue.setText("");
                        lastNameValue.setText("");
                        phoneNumberValue.setText("");
                        passwordValue.setText("");
                        errorMessageValue.setText("");
                        User newUser = new User(firstNameValue.getText().toString(),
                                lastNameValue.getText().toString(),
                                phoneNumberValue.getText().toString(),
                                passwordValue.getText().toString()
                                );
                        Dbuser dbuser = new Dbuser(getApplicationContext());
                        dbuser.open();
                        dbuser.insertUser(newUser);
                        //dbuser.close();
                        Intent intentSignUpActivity = new Intent(SignUpActivity.this,HomeActivity.class);
                        startActivity(intentSignUpActivity);
                        finish();
                    }
                }

            }
        });
        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToLogin = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intentToLogin);
            }
        });
    }
}
