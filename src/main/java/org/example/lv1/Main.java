package org.example.lv1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final String NUMBER_REG = "^[0-9]+$";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // 반복문을 제어할 플래그
        String functionFlag = "start";
        // 메뉴를 담는 배열
        String[] menus = {
                "ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거",
                "종료      | 종료"
        };

        // 반복해서 키오스크 메뉴 출력하는 반복문
        while(!functionFlag.equals("0")){

            System.out.println("[ SHAKESHACK MENU ]");

            // 메뉴를 출력
            for(int i = 0; i < menus.length; i++){
                System.out.println((i + 1) % menus.length + ". " + menus[i]);
            }

            functionFlag = readFunctionFlag();
        }

    }

    private static String readFunctionFlag(){
        String functionFlag = scanner.nextLine();
        while(!Pattern.matches(NUMBER_REG, functionFlag) || Integer.parseInt(functionFlag) > 4){
            if(!Pattern.matches(NUMBER_REG, functionFlag)){
                System.out.print("잘못된 입력 형식입니다. 0-4 사이의 정수를 입력해주세요: ");
            }
            else{
                System.out.print("잘못된 번호입니다. 0-4 사이의 번호를 입력해주세요: ");
            }
            functionFlag = scanner.nextLine();
        }
        return functionFlag;
    }

    private static String readNumber(){
        String number = scanner.nextLine();
        while(!Pattern.matches(NUMBER_REG,number)){
            System.out.print("정수 형태를 입력해 주세요: ");
            number = scanner.nextLine();
        }
        return number;
    }
}