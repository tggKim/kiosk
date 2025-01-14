package org.example.lv5_challenge;

import java.util.List;

public class Menu {
    private List<MenuItem> menus;
    private String category;
    int sequence = 0;

    public Menu(String category, List<MenuItem> menus){
        this.category = category;
        this.menus = menus;
    }

    // 메뉴를 출력하는 메서드
    public void showMenu(){
        menus.stream().forEach(a -> System.out.println((sequence + 1) + ". " + menus.get(sequence++)));
        sequence = 0;
//        for(int i = 0; i < menus.size(); i++){
//            System.out.println((i + 1) + ". " + menus.get(i));
//        }
    }

    public List<MenuItem> getMenus() {
        return menus;
    }

    public String getCategory() {
        return category;
    }
}
