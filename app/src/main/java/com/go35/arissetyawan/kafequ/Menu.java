package com.go35.arissetyawan.kafequ;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by arissetyawan on 23/09/16.
 */
public class Menu {
    private int id;
    private String name;
    private int stock;
    private int price;
    private int discount;
    private Date createdAt;

    public Menu (String name, int stock, int price, int discount)
    {
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.discount = discount;
    }
    public  Menu(){

    }

    public static Menu find(int id){
        return new Menu();
    }

    protected boolean update(){
        return true;
    }

    public static Menu create(String name, int stock, int price, int discount)
    {
        return new Menu();
    }

    protected boolean destroy()
    {
        return true;
    }


}
