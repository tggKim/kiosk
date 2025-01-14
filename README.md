# Lv1

### 기능

  - scanner를 통해서 사용자의 입력을 받고 정규식을 통해 검증한다.

### Main 클래스

  - 이 클래스에서 인터페이스를  콘솔에 출력하고 사용자의 입력을 받아들인다.

    - 사용자가 올바른 값을 입력할 때까지 반복한다. 

  - 메뉴가 저장된 배열의 크기에 따라서 출력되는 인터페이스의 값들이 조정되도록 만들었다.

    - 메뉴가 저장된 배열의 크기가 n이면 입력해야 되는 값이 0에서 n-1 사이가 된다.
   
    - for문이 n번만큼  반복해서 모든 메뉴를 출력한다.
   
# Lv2

### 기능

  - MenuItem 클래스를 통해서 메뉴 객체를 생성하여 관리한다

  - List에 MenuItem 객체를 저장하고 불러올 수 있도록 함

### MenuItem 클래스

  - 메뉴에 대한 정보를 가지는 클래스

  - 내부에 toString()을 재정의 해서 출력될때의 형식을 정의했다.

# Lv3

### 기능

  - Kiosk 클래스를 만들어서 사용자의 입력을 처리하고 메뉴를 관리하도록 했다

  - 이제 Main클래스에서는 Kiosk 객체를 생성해서 start()메서드를 호출하기만 하면 된다.

### Kiosk 클래스

  - 원래 Main에서 처리하던 메뉴 출력과 사용자 입력 로직을 담당하는 클래스

  - 생성자를 통해서 MenuItem에 대한 List를 받아서 화면에 출력한다.

# Lv4 와 Lv5

### 기능

  - Menu 클래스를 만들어서 음식별 카테고리를 만들었다.

  - 카테고리를 선택한 뒤 카테고리에 해당하는 메뉴들을 볼 수 있고 선택할 수 있다.

  - 필드들이 모두 private으로 설정되어있어서 임의로 필드값을 변경할 수 없도록 설정했으며 getter()를 통해서 값을 가져온다.

### Menu 클래스

  - 카테고리를 의미하는 category 필드와 메뉴들을 저장하는 menus를 필드로 가진다.

  - 메뉴의 목룍을 출력하는 showMenu()와 필드에 대한 getter() 메서드도 존재한다.

### Kiosk 클래스

  - Menu를 List로 가지고 있어서 카테고리를 출력하고
  
  - 선택한 카테고리의 메뉴들을 출력한다.

  - 선택한 메뉴를 출력

  - 카테고리 선택에서 0번을 통해서 키오스크를 종료하거나 메뉴선택에서 0번을 통해서 카테고리 선택 페이지로 돌아갈 수 있다.

# 도전 과제 Lv1

### 기능

  - 장바구니 클래스인 ShoppingCart와 장바구니에 담길 상품인 CartItem 클래스를 만들어서 장바구니 기능을 구현함

  - 선택한 상품을 장바구니에 담을 수 있고, 장바구니에 담긴 물건을 주문하거나 취소할 수 있다.

### CartItem 클래스

  - 메뉴에 대한 정보 그리고 수량을 가지는 클래스

  - 생성자를 통해서 MenuItem을 인자로 받아서 상품의 정보를 저장한다.

  - toString()을 재정의해서 출력 형식을 정의했다.

  - equals()를 재정의 해서 List에 담겨있을때 menuName을 기준으로 contains()와 indexOf()의 값이 나오도록 만들었다.

### ShoppingCart 클래스

  - CartItem을 List로 가진다.

    - addCartItem() 메서드로 List에 CartItem이 있으면 수량을 증가시키고 없다면 추가한다.
   
    - showCartItem() 메서드로 장바구니에 담긴 모든 CartItem들을 출력한다.
   
    - getTotalPrice()로 장바구니의 총 가격을 리턴한다.
   
    - hasCartItem()으로 장바구니에 담긴 CartItem이 있는지 확인한다.

    - clearCartItems()로 장바구니를 비운다.
   
### Kiosk 클래스

  - 상품을 선택 후 장바구니에 추가할지 여부를 묻는 로직을 만들었다.

    - 이 때 사용할 readOneOrTwo() 메서드를 사용해서 1혹은 2를 입력값으로 받아온다.
   
  - 장바구니에 상품이 존재하면 메뉴에서 "장바구니 확인 후 주문합니다", "진행중인  주문을  취소합니다" 메뉴가 출력되도록 변경

    - 카테고리의 크기에 따라서 앞에 붙는 숫자가 변할 수 있도록 설계함
   
    - 원하는 메뉴를 입력할때 사용하는 readfunctionFlag() 메서드를 장바구니가 비어있을때와 비어있지않을때로 구분해서 입력을 받아들이도록 수정했다.

      - 예시로 카테고리가 n개면 n+1번, n+2번이 장바구니 확인과 주문 취소 메뉴이므로 이에 해당하는 숫자를 입력받을 수 있도록 수정했다.

  - "장바구니 확인 후 주문합니다" 선택 후 장바구니 목록과 총 금액을 출력하도록 하고 주문할 수 있도록 수정했다.
