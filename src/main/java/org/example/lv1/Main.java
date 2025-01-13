package org.example.lv1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final String NUMBER_REG = "^[0-9]+$";
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {



    }

    private static String readFunctionFlag(){
        String functionFlag = scanner.nextLine();
        while(!Pattern.matches(NUMBER_REG, functionFlag) || Integer.parseInt(functionFlag) > 4){
            if(!Pattern.matches(NUMBER_REG, functionFlag)){
                System.out.print("잘못된 입력 형식입니다. 1-4 사이의 정수를 입력해주세요: ");
            }
            else{
                System.out.print("잘못된 번호입니다. 1-4 사이의 번호를 입력해주세요: ");
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