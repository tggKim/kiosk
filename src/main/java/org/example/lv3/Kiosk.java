package org.example.lv3;

import org.example.lv3.MenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Kiosk {
    private final String NUMBER_REG = "^[0-9]+$";
    private Scanner scanner = new Scanner(System.in);
    private List<MenuItem> menus;

    public Kiosk(List<MenuItem> menus){
        this.menus = menus;
    }

    public void start(){
        // 반복문을 제어할 플래그
        String functionFlag = "start";

        // 반복해서 키오스크 메뉴 출력하는 반복문
        while(!functionFlag.equals("0")){

            System.out.println("[ SHAKESHACK MENU ]");

            // 메뉴를 출력
            for(int i = 0; i < menus.size(); i++){
                System.out.println((i + 1) + ". " + menus.get(i));
            }
            System.out.println(String.format("0. %-15s| 종료","exit"));

            // 사용자에게 입력을 받음
            functionFlag = readFunctionFlag();
            int menuNumber = Integer.parseInt(functionFlag);
            // 입력한 숫자가 0이 아니라면 해당되는 메뉴를 출력, 0이면 종료
            if(menuNumber != 0){
                System.out.println("============================================================================");
                System.out.println(menus.get(menuNumber-1));
                System.out.println("============================================================================");
            }
            else{
                System.out.println("============================================================================");
                System.out.println("프로그램을 종료합니다.");
                System.out.println("============================================================================");
            }
            // 한 칸 띄기
            System.out.println();
        }
    }

    // 사용자의 입력을 받아들이는 함수
    private String readFunctionFlag(){
        String functionFlag = scanner.nextLine();
        // 정규식의 표현과 맞지 않거나 메뉴에 없는 숫자를 입력하면 반복해서 입력하도록 지시함
        while(!Pattern.matches(NUMBER_REG, functionFlag) || Integer.parseInt(functionFlag) > menus.size()){
            System.out.print("잘못된 입력 형식입니다. 0-" + (menus.size()) + " 사이의 번호를 입력해주세요: ");
            functionFlag = scanner.nextLine();
        }
        return functionFlag;
    }
}
