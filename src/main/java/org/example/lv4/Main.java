package org.example.lv4;

import org.example.lv4.MenuItem;
import org.example.lv4.Kiosk;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        // 카테고리별 메뉴 리스트
        List<MenuItem> menus = new ArrayList<>();

        menus.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menus.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menus.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menus.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menus.add(new MenuItem("soop", 7.4, "졸라 맛있는 수프"));

        // 카터고리 리스트
        List<Menu> menuCategory = new ArrayList<>();

        menuCategory.add(new Menu("Burgers", menus));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menuCategory);

        // Kiosk 시작
        kiosk.start();
    }

}
