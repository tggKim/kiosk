package org.example.lv5_challenge.cart;

import org.example.lv5_challenge.MenuItem;

public class CartItem {
    private String menuName;
    private double menuPrice;
    private String menuDescription;
    private int quantity;

    public CartItem(MenuItem menuItem){
        this.menuName = menuItem.getMenuName();
        this.menuPrice = menuItem.getMenuPrice();
        this.menuDescription = menuItem.getMenuDescription();
        quantity = 0;
    }

    public String getMenuName() {
        return menuName;
    }

    public double getMenuPrice() {
        return menuPrice;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public int getQuantity() {
        return quantity;
    }
}
