package org.example.lv4;

public class MenuItem {
    private String menuName;
    private double menuPrice;
    private String menuDescription;

    public MenuItem(String menuName, double menuPrice, String menuDescription){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
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

    @Override
    public String toString() {
        return String.format("%-15s|",menuName)+ " W " + menuPrice + " | " + menuDescription;
    }
}
