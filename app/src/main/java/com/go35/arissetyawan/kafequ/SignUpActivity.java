package com.go35.arissetyawan.kafequ;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
                TextView u = (TextView) findViewById(R.id.signup_username);
                TextView p = (TextView) findViewById(R.id.signup_password);;
                TextView s = (TextView) findViewById(R.id.signup_shop_name);

                if(TextUtils.isEmpty(u.getText().toString()))
                {
                    u.setError("cant be blank");
                }
                if(TextUtils.isEmpty(p.getText().toString()))
                {
                    p.setError("cant be blank");
                }
                if(TextUtils.isEmpty(s.getText().toString()))
                {
                    s.setError("cant be blank");
                }
            }
        });
        // -- register click event with second button ---
        lButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_login);
            }
        });
    }
}
