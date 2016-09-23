package com.go35.arissetyawan.kafequ;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //--- find both the                                                                                                                                                                                                                                                             buttons---
        Button sButton = (Button) findViewById(R.id.signup_button);
        Button lButton = (Button) findViewById(R.id.login_button);

        // -- register click event with first button ---
        sButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                User user = new User();
                user.usernameInput = (TextView) findViewById(R.id.signup_username);
                user.passwordInput = (TextView) findViewById(R.id.signup_password);
                user.shopnameInput = (TextView) findViewById(R.id.signup_shop_name);
                if(user.validate()) {
                    Intent intentMain = new Intent(SignUpActivity.this, MainActivity.class);
                    SignUpActivity.this.startActivity(intentMain);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), user.message,Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    user.displayErrors();
                }
            }
        });

        lButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMain = new Intent(SignUpActivity.this ,LoginActivity.class);
                SignUpActivity.this.startActivity(intentMain);
                Log.i("Content "," Main layout ");
            }
        });
    }
}
