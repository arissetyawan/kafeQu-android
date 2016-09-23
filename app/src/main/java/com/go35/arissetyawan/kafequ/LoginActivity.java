package com.go35.arissetyawan.kafequ;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LoginActivity extends AppCompatActivity {
    private TextView usernameInput;
    private TextView passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button lButton = (Button) findViewById(R.id.login_button);
        Button sButton = (Button) findViewById(R.id.signup_button);

        lButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                User user = new User();
                usernameInput = (TextView) findViewById(R.id.login_username);
                passwordInput = (TextView) findViewById(R.id.login_password);
                user.username = usernameInput.getText().toString();
                user.password = passwordInput.getText().toString();
                if(user.validate(true)){
                    Log.d("OK", "OKKK");
                }
                else{
                    Toast.makeText(getApplicationContext(), user.message,Toast.LENGTH_SHORT).show();
                    displayErrors(user.errors);
                }
            }
        });

        sButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intentMain = new Intent(LoginActivity.this ,SignUpActivity.class);
                LoginActivity.this.startActivity(intentMain);
                Log.i("Content "," Main layout ");
            }
        });
    }


    private void displayErrors(HashMap hm)
    {
        Set set = hm.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            if(me.getKey()=="username"){
                usernameInput.setError(me.getValue().toString());
            }
            if(me.getKey()=="password"){
                passwordInput.setError(me.getValue().toString());
            }
        }
    }
}
