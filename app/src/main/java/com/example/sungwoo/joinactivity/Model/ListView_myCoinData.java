package com.example.sungwoo.joinactivity.Model;

public class ListView_myCoinData {
   private int coinimage;
   private String money_name;
   private double money_quantity;
   private String en_money_name;

   public ListView_myCoinData(){}

    public ListView_myCoinData(int coinimage, String money_name, double money_quantity, String en_money_name) {
        this.coinimage = coinimage;
        this.money_name = money_name;
        this.money_quantity = money_quantity;
        this.en_money_name = en_money_name;
    }

    public int getCoinimage() {
        return coinimage;
    }

    public void setCoinimage(int coinimage) {
        this.coinimage = coinimage;
    }

    public String getMoney_name() {
        return money_name;
    }

    public void setMoney_name(String money_name) {
        this.money_name = money_name;
    }

    public double getMoney_quantity() {
        return money_quantity;
    }

    public void setMoney_quantity(double money_quantity) {
        this.money_quantity = money_quantity;
    }

    public String getEn_money_name() {
        return en_money_name;
    }

    public void setEn_money_name(String en_money_name) {
        this.en_money_name = en_money_name;
    }
}
