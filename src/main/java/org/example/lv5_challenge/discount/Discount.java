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

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public static void showDiscount(){
        for(Discount discount : values()){
            System.out.println(discount.getSequenceNumber() + ". " + discount.getDescription() + " : " + discount.getDiscountRate() + "%");
        }
    }

    public static double calculateDiscount(int sequenceNumber, double money){
        double calculatedMoney = 0;
        for(Discount discount : values()){
            if(discount.getSequenceNumber() == sequenceNumber){
                calculatedMoney = money * ((double)(100-discount.getDiscountRate())/100);
                break;
            }
        }
        return calculatedMoney;
    }
}
