package org.example.lv2;

public class MenuItem {
    private String menuName;
    private String menuPrice;
    private String menuDescription;

    public MenuItem(String menuName, String menuPrice, String menuDescription){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuDescription = menuDescription;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuPrice() {
        return menuPrice;
    }

    public String getMenuDescription() {
        return menuDescription;
    }
}
