package com.go35.arissetyawan.kafequ;

import android.util.Log;
import android.widget.TextView;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by arissetyawan on 22/09/16.
 */
public class User {
    InputValidator  inputValidatorHelper = new InputValidator();
    private static final String TAG = "User";

    private int id;
    private Date createdAt;
    private boolean allowSave = true;

    protected HashMap errors = new HashMap();

    protected String username;
    protected String password;
    protected String shopname;
    protected String message;

    protected TextView usernameInput;
    protected TextView passwordInput;
    protected TextView shopnameInput;

    public void User(String username, String password, String shopname){
        this.username = username;
        this.password = password;
        this.shopname = shopname;
    }
    public void User(){
    }

    public User find(int id){
        User user = new User();
        user.id = id;
        user.username = "u";
        user.password = "p";
        user.shopname = "s";
        return user;
    }

    protected boolean destroy()
    {
        // sql delete or api delete calls
        return true;
    }

    protected boolean update()
    {
        // sql saving or api
        return true;
    }

    protected boolean authenticate(){

        if(loginValidation())
        {
            return true;
        }
        return false;
    }

    protected void displayErrors()
    {
        Set set = errors.entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {

            Map.Entry me = (Map.Entry)i.next();
            if(me.getKey()=="username"){
                usernameInput.setError(me.getValue().toString());
            }
            if(me.getKey()=="password"){
                passwordInput.setError(me.getValue().toString());
            }
            if(me.getKey()=="shopname"){
                shopnameInput.setError(me.getValue().toString());
            }
        }
    }

    private boolean loginValidation(){
        this.username = this.usernameInput.getText().toString();
        this.password = this.passwordInput.getText().toString();
        if (inputValidatorHelper.isNullOrEmpty(username)) {
            errors.put("username", "cant be blank");
            allowSave = false;
        }

        if (!inputValidatorHelper.isNullOrEmpty(username) && !inputValidatorHelper.isValidEmail(username)) {
            errors.put("username", "is invalid email");
            allowSave = false;
        }

        if (inputValidatorHelper.isNullOrEmpty(password)) {
            errors.put("password", "cant be empty");
            allowSave = false;
        }
        if(!allowSave){
            message = "Login has failed";
        }
        return allowSave;
    }

    protected boolean validate(){
        allowSave = loginValidation();
        this.shopname = this.shopnameInput.getText().toString();

        if (inputValidatorHelper.isNullOrEmpty(shopname)) {
            errors.put("shopname", "cant be empty");
            allowSave = false;
        }
        if(!allowSave){
            message = "Check input and try again";
        }
        return allowSave;
    }

    protected boolean create(){
        if(allowSave){
            // sql insert
            return true;
        }
        return false;
    }

}
