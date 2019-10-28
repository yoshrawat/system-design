package com.system.design.edu.amazon;

public class Customer {
    private ShoppingCart cart;
    private Order order;

    public ShoppingCart getShoppingCart(){ return null;}
    public boolean addItemToCart(Item item){ return true;}
    public boolean removeItemFromCart(Item item){ return true;}
}
