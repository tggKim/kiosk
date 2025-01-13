package org.example.lv4andlv5;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Kiosk {
    private final String NUMBER_REG = "^[0-9]+$";
    private Scanner scanner = new Scanner(System.in);
    private List<Menu> menuCategory;
    private Menu selelectedMenu;

    public Kiosk(List<Menu> menuCategory){
        this.menuCategory = menuCategory;
    }

    public void start(){
        // 반복문을 제어할 플래그
        String functionFlag = "start";

        // 반복해서 키오스크 메뉴 출력하는 반복문
        while(!functionFlag.equals("0")){

            // 카테고리 출력
            System.out.println("[ MAIN MENU ]");
            for(int i = 0; i < menuCategory.size(); i++){
                System.out.println((i + 1) + ". " + menuCategory.get(i).getCategory());
            }
            System.out.println("0. exit");

            // 사용자에게 입력을 받음
            functionFlag = readFunctionFlag();
            int categoryNumber = Integer.parseInt(functionFlag);
            // 입력한 숫자가 0이 아니라면 해당되는 메뉴를 출력, 0이면 종료
            if(categoryNumber == 0){
                System.out.println("============================================================================");
                System.out.println("프로그램을 종료합니다.");
                System.out.println("============================================================================");
                break;
            }

            // 카테고리에 해당되는 Menu 객체를 불러옴
            selelectedMenu = menuCategory.get(categoryNumber - 1);

            // 카테고리별 메뉴 출력
            System.out.println("\n[ " + selelectedMenu.getCategory() + " MENU ]");
            selelectedMenu.showMenu();
            System.out.println("0. 뒤로가기");

            // 카테고리별 메뉴 선택
            int menuNumber = readMenuNumber();
            // 0을 입력하면 continue해서 다시 카테고리 선택 메뉴 보여줌
            if(menuNumber == 0){
                System.out.println();
                continue;
            }

            System.out.println("============================================================================");
            System.out.println(selelectedMenu.getMenus().get(menuNumber - 1));
            System.out.println("============================================================================");

            // 한 칸 띄기
            System.out.println();
        }
    }

    // 사용자의 입력을 받아들이는 함수
    private String readFunctionFlag(){
        String functionFlag = scanner.nextLine();
        // 정규식의 표현과 맞지 않거나 메뉴에 없는 숫자를 입력하면 반복해서 입력하도록 지시함
        while(!Pattern.matches(NUMBER_REG, functionFlag) || Integer.parseInt(functionFlag) > menuCategory.size()){
            System.out.print("잘못된 입력 형식입니다. 0-" + (menuCategory.size()) + " 사이의 번호를 입력해주세요: ");
            functionFlag = scanner.nextLine();
        }
        return functionFlag;
    }

    private int readMenuNumber(){
        String menuNumberString = scanner.nextLine();
        // 정규식의 표현과 맞지 않거나 메뉴에 없는 숫자를 입력하면 반복해서 입력하도록 지시함
        while(!Pattern.matches(NUMBER_REG, menuNumberString) || Integer.parseInt(menuNumberString) > selelectedMenu.getMenus().size()){
            System.out.print("잘못된 입력 형식입니다. 0-" + (selelectedMenu.getMenus().size()) + " 사이의 번호를 입력해주세요: ");
            menuNumberString = scanner.nextLine();
        }
        return Integer.parseInt(menuNumberString);
    }
}
