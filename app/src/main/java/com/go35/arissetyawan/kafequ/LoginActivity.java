package com.go35.arissetyawan.kafequ;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button lButton = (Button) findViewById(R.id.login_button);
        Button sButton = (Button) findViewById(R.id.signup_button);

        lButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                TextView u = (TextView) findViewById(R.id.login_username);
                TextView p = (TextView) findViewById(R.id.login_password););

                User user = new User();
                user.username = u.getText().toString();
                user.password = p.getText().toString();
                if(user.validate()){

                }
                else{

                }
            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setContentView(R.layout.activity_sign_up);
            }
        });
    }
}
