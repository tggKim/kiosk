package org.example.lv5_challenge.discount;

public enum Discount {
    VETERAN(1, "국가유공자", 10),
    SOLDIER(2, "군인", 5),
    STUDENT(3, "학생", 3),
    GENERAL(4, "일반", 0);

    private int sequenceNumber;
    private String description;
    private int discountRate;

    private Discount(int sequenceNumber, String description, int discountRate){
        this.sequenceNumber = sequenceNumber;
        this.description = description;
        this.discountRate = discountRate;
    }

    public void showDiscount(){
        Discount[] discounts = values();
        for(int i = 0; i < discounts.length; i++){
            System.out.println(sequenceNumber + ". " + description + " : " + discountRate + "%");
        }
    }

    public double calculateDiscount(int sequenceNumber, double money){
        double calculatedMoney = 0;
        for(Discount discount : values()){
            if(discount.sequenceNumber == sequenceNumber){
                calculatedMoney = money * ((double)(100-discount.discountRate)/100);
            }
        }
        return calculatedMoney;
    }
}
