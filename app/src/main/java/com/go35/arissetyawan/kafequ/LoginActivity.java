package com.go35.arissetyawan.kafequ;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button lButton = (Button) findViewById(R.id.login_button);
        Button sButton = (Button) findViewById(R.id.signup_button);

        lButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                User user = new User();
                user.usernameInput = (TextView) findViewById(R.id.login_username);
                user.passwordInput = (TextView) findViewById(R.id.login_password);
                if(user.authenticate()) {
                    Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intentMain);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(), user.message,Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                    user.displayErrors();
                }
            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMain = new Intent(LoginActivity.this ,SignUpActivity.class);
                LoginActivity.this.startActivity(intentMain);
            }
        });
    }

}
