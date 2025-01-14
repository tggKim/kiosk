package org.example.lv5_challenge;

import org.example.lv5_challenge.cart.CartItem;
import org.example.lv5_challenge.cart.ShoppingCart;
import org.example.lv5_challenge.discount.Discount;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Kiosk {
    private final String NUMBER_REG = "^[0-9]+$";
    private Scanner scanner = new Scanner(System.in);
    private List<Menu> menuCategory;
    private Menu selectedCategory;
    private ShoppingCart shoppingCart = new ShoppingCart();

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

            // 만약 장바구니에 물건이 있다면 출력되는 부분
            if(shoppingCart.hasCartItem()){
                System.out.println("\n[ ORDER MENU ]");
                // 앞에 붙는 번호가 menuCategory 크기에 따라서 변하도록 작성
                System.out.println((menuCategory.size() + 1) + String.format(".%-15s|"," Orders") + " 장바구니를 확인 후 주문합니다.");
                System.out.println((menuCategory.size() + 2) + String.format(".%-15s|"," Cancel") + " 진행중인 주문을 취소합니다.");
            }

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

            // 장바구니 주문하거나 주문 취소하는 로직
            if(categoryNumber == menuCategory.size() + 1){
                System.out.println("\n아래와 같이 주문 하시겠습니까?\n\n[ Orders ]");
                shoppingCart.showCartItems();
                System.out.println("\n[ Total ]");
                System.out.println("W " + shoppingCart.getTotalPrice());
                System.out.println("\n1. 주문\t2. 메뉴판");

                int orderOption = readOneOrTwo();
                if(orderOption == 1){
                    // 할인 정보 출력
                    System.out.println("\n할인 정보를 입력해주세요.");
                    Discount.showDiscount();

                    // 할인 정보 입력 받음
                    int discountOption = readDiscountOption();

                    //주문 완료 금액 할인 적용해서 출력
                    System.out.println("\n주문이 완료되었습니다. 금액은 W " + Discount.calculateDiscount(discountOption, shoppingCart.getTotalPrice()) + " 입니다.");
                    shoppingCart.clearCartItems();
                }
                System.out.println();
                continue;
            }
            else if(categoryNumber == menuCategory.size() + 2){
                shoppingCart.clearCartItems();
                System.out.println("============================================================================");
                System.out.println("장바구니의 주문들을 취소했습니다.");
                System.out.println("============================================================================");
                System.out.println();
                continue;
            }

            // 카테고리에 해당되는 Menu 객체를 불러옴
            selectedCategory = menuCategory.get(categoryNumber - 1);

            // 카테고리별 메뉴 출력
            System.out.println("\n[ " + selectedCategory.getCategory() + " MENU ]");
            selectedCategory.showMenu();
            System.out.println("0. 뒤로가기");

            // 카테고리별 메뉴 선택
            int menuNumber = readMenuNumber();
            // 0을 입력하면 continue해서 다시 카테고리 선택 메뉴 보여줌
            if(menuNumber == 0){
                System.out.println();
                continue;
            }

            // 선택한 메뉴 출력
            MenuItem selectedMenu = selectedCategory.getMenus().get(menuNumber - 1);
            System.out.println("============================================================================");
            System.out.println("선택한 메뉴: " + selectedMenu);
            System.out.println("============================================================================");
            System.out.println();

            // 장바구니 추가 로직 시작
            System.out.println("\"" + selectedMenu + "\" \n위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인 \t2.취소");
            int shoppingCartAddOption =  readOneOrTwo();
            // 1번을 입력하면 장바구니에 상품을 담는다.
            if(shoppingCartAddOption == 1){
                shoppingCart.addCartItem(new CartItem(selectedMenu));
                System.out.println("\n" + selectedMenu.getMenuName() + " 이 장바구니에 추가되었습니다.");
            }
            System.out.println();

        }
    }

    // 사용자의 입력을 받아들이는 함수
    private String readFunctionFlag(){
        String functionFlag = scanner.nextLine();
        // 정규식의 표현과 맞지 않거나 메뉴에 없는 숫자를 입력하면 반복해서 입력하도록 지시함
        if(shoppingCart.hasCartItem()){
            while(!Pattern.matches(NUMBER_REG, functionFlag) || Integer.parseInt(functionFlag) > menuCategory.size() + 2){
                System.out.print("잘못된 입력 형식입니다. 0-" + (menuCategory.size() + 2) + " 사이의 번호를 입력해주세요: ");
                functionFlag = scanner.nextLine();
            }
        }
        else{
            while(!Pattern.matches(NUMBER_REG, functionFlag) || Integer.parseInt(functionFlag) > menuCategory.size()){
                System.out.print("잘못된 입력 형식입니다. 0-" + (menuCategory.size()) + " 사이의 번호를 입력해주세요: ");
                functionFlag = scanner.nextLine();
            }
        }
        return functionFlag;
    }

    private int readMenuNumber(){
        String menuNumberString = scanner.nextLine();
        while(!Pattern.matches(NUMBER_REG, menuNumberString) || Integer.parseInt(menuNumberString) > selectedCategory.getMenus().size()){
            System.out.print("잘못된 입력 형식입니다. 0-" + (selectedCategory.getMenus().size()) + " 사이의 번호를 입력해주세요: ");
            menuNumberString = scanner.nextLine();
        }
        return Integer.parseInt(menuNumberString);
    }

    private int readOneOrTwo(){
        String oneOrTwo = scanner.nextLine();
        while(!Pattern.matches(NUMBER_REG, oneOrTwo) || Integer.parseInt(oneOrTwo) > 2 || Integer.parseInt(oneOrTwo) <= 0){
            System.out.print("잘못된 입력 형식입니다. 1번 혹은 2번을 입력해 주세요: ");
            oneOrTwo = scanner.nextLine();
        }
        return Integer.parseInt(oneOrTwo);
    }

    private int readDiscountOption(){
        String discountOption = scanner.nextLine();
        while(!Pattern.matches(NUMBER_REG, discountOption) || Integer.parseInt(discountOption) > Discount.values().length || Integer.parseInt(discountOption) <= 0){
            System.out.print("잘못된 입력 형식입니다. 1-" + Discount.values().length + " 사이의 번호를 입력해주세요: ");
            discountOption = scanner.nextLine();
        }
        return Integer.parseInt(discountOption);
    }
}
