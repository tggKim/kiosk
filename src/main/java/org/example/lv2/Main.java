package org.example.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final String NUMBER_REG = "^[0-9]+$";
    private static Scanner scanner = new Scanner(System.in);
    private static List<MenuItem> menus = new ArrayList<>();

    public static void main(String[] args){

    }

    // 사용자의 입력을 받아들이는 함수
    private static String readFunctionFlag(){
        String functionFlag = scanner.nextLine();
        // 정규식의 표현과 맞지 않거나 메뉴에 없는 숫자를 입력하면 반복해서 입력하도록 지시함
        while(!Pattern.matches(NUMBER_REG, functionFlag) || Integer.parseInt(functionFlag) > menus.size() - 1){
            System.out.print("잘못된 입력 형식입니다. 0-" + (menus.size() - 1) + " 사이의 번호를 입력해주세요: ");
            functionFlag = scanner.nextLine();
        }
        return functionFlag;
    }

}
