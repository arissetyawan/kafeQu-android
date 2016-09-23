package com.go35.arissetyawan.kafequ;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by arissetyawan on 23/09/16.
 */
public class Order {
    private int id;
    private String customerName;
    private int quantity;
    private int price;
    private int totalPrice;
    private int discount;
    private Date createdAt;

    public Order (String customerName, int quantity, int price, int discount)
    {
        this.customerName = customerName;
        this.quantity = quantity;
        this.price = price;
        this.discount = discount;
        this.totalPrice = ( quantity * price ) - discount;
        this.createdAt = new Date();
    }
    public Order(){

    }

    public static Order find(int id){
        return new Order();
    }

    protected boolean update(){
        return true;
    }

    public static Order create(String name, int stock, int price, int discount)
    {
        return new Order();
    }

    protected boolean destroy()
    {
        return true;
    }


}
