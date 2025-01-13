package org.example.lv5_challenge;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        // 카테고리별 메뉴 리스트
        List<MenuItem> menus1 = new ArrayList<>();

        menus1.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menus1.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menus1.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menus1.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        List<MenuItem> menus2 = new ArrayList<>();

        menus2.add(new MenuItem("Sparkling", 3.2, "시원한 탄산음료"));
        menus2.add(new MenuItem("BerryBurst", 4.3, "베리를 갈아서 만든 슬러시"));
        menus2.add(new MenuItem("MintyFresh", 2.5, "민트맛 음료수"));

        // 카터고리 리스트
        List<Menu> menuCategory = new ArrayList<>();

        menuCategory.add(new Menu("Burgers", menus1));
        menuCategory.add(new Menu("Drinks", menus2));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menuCategory);

        // Kiosk 시작
        kiosk.start();
    }

}
