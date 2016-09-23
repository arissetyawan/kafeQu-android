package com.go35.arissetyawan.kafequ;

import java.util.HashMap;

/**
 * Created by arissetyawan on 22/09/16.
 */
public class User {
    InputValidator  inputValidatorHelper = new InputValidator();

    protected HashMap errors = new HashMap();
    private boolean allowSave = true;
    protected String username;
    protected String password;
    protected String shopname;
    protected String message;
    private int id;

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
        return false;
    }

    protected boolean validate(boolean login){
        //Validate and Save
        if (inputValidatorHelper.isNullOrEmpty(username)) {
            errors.put("username", "cant be blank");
            allowSave = false;
        }

        if (!inputValidatorHelper.isValidEmail(username)) {
            errors.put("username", "is invalid email");
            allowSave = false;
        }

        if (inputValidatorHelper.isNullOrEmpty(password)) {
            errors.put("password", "cant be empty");
            allowSave = false;
        }
        if (!login && inputValidatorHelper.isNullOrEmpty(shopname)) {
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
