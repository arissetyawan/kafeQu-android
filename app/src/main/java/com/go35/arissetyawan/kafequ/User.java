package com.go35.arissetyawan.kafequ;

/**
 * Created by arissetyawan on 22/09/16.
 */
public class User {
    InputValidator  inputValidatorHelper = new InputValidator();

    protected StringBuilder errMsg = new StringBuilder("Check input and try again.\n");
    private boolean allowSave;
    protected String username;
    protected String password;
    protected String shopname;
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

    protected boolean validate(){
        //Validate and Save
        if (username == null && !inputValidatorHelper.isValidEmail(username)) {
            errMsg.append("- invalid email address.\n");
            allowSave = false;
        }

        if (inputValidatorHelper.isNullOrEmpty(password)) {
            errMsg.append("- password should not be empty.\n");
            allowSave = false;
        }
        if (inputValidatorHelper.isNullOrEmpty(shopname)) {
            errMsg.append("- shop name should not be empty.\n");
            allowSave = false;
        }
        allowSave = true;
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
