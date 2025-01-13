package org.example.lv4;

import org.example.lv4.MenuItem;

import java.util.List;

public class Menu {
    private List<MenuItem> menus;
    private String category;

    public Menu(String category, List<MenuItem> menus){
        this.category = category;
        this.menus = menus;
    }

    // 메뉴를 출력하는 메서드
    public void showMenu(){
        for(int i = 0; i < menus.size(); i++){
            System.out.println((i + 1) + ". " + menus.get(i));
        }
    }

    public List<MenuItem> getMenus() {
        return menus;
    }

    public String getCategory() {
        return category;
    }
}
