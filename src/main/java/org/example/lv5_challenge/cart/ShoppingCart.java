package org.example.lv5_challenge.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {

    private List<CartItem> cartItems = new ArrayList<>();

    // cartItem이 존재하면 quantity를 1증가시키고 리스트에 없으면 추가한다.
    public void addCartItem(CartItem cartItem){
        if(cartItems.contains(cartItem)){
            CartItem findCartItem = cartItems.get(cartItems.indexOf(cartItem));
            findCartItem.incrementQuantity();
        }
        else{
            cartItems.add(cartItem);
        }
    }

    // 장바구니에 담긴 상품이 있는지 판단하는 메서드
    public boolean hasCartItem(){
        return !cartItems.isEmpty();
    }

    public boolean removeCartItemByName(String menuName){
        List<CartItem> cartItems = this.cartItems.stream().filter(cartItem -> !cartItem.getMenuName().equals(menuName))
                .collect(Collectors.toCollection(ArrayList::new));
        if(cartItems.size() < this.cartItems.size()){
            this.cartItems = cartItems;
            return true;
        }
        return false;
    }

    // 장바구니에 담긴 총 금액을 리턴하는 메서드
    public double getTotalPrice(){
        double totalPrice = 0;
        for(CartItem cartItem : cartItems){
            totalPrice += (cartItem.getQuantity() * cartItem.getMenuPrice());
        }
        return totalPrice;
    }

    public void showCartItems(){
        for(CartItem cartItem : cartItems){
            System.out.println(cartItem);
        }
    }

    public void clearCartItems(){
        cartItems.clear();
    }
}
