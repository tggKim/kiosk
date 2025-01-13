package org.example.lv5_challenge.cart;

import org.example.lv5_challenge.MenuItem;

import java.util.Objects;

public class CartItem {
    private String menuName;
    private double menuPrice;
    private String menuDescription;
    private int quantity;

    public CartItem(MenuItem menuItem){
        this.menuName = menuItem.getMenuName();
        this.menuPrice = menuItem.getMenuPrice();
        this.menuDescription = menuItem.getMenuDescription();
        quantity = 1;
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

    public void incrementQuantity(){
        quantity++;
    }

    @Override
    public String toString() {
        return String.format("%-15s|",menuName)+ " W " + menuPrice + " | " + menuDescription + " 수량: " + quantity;
    }

    // CartItem이 저장된 List에서 해당 CartItem을 contains()와 indexOf()로 찾을 수 있도록 equals() 재정의함, menuName을 기준으로 구분하도록 했다.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return this.menuName.equals(cartItem.getMenuName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuName, menuPrice, menuDescription, quantity);
    }
}
