package com.example.sungwoo.joinactivity.Model;

public class Listview_CoinData {
    private String coin_name;
    private int coin_currentprice;
    private double coin_change;
    private double coin_transaction_value;

    public Listview_CoinData(){
    }

    public Listview_CoinData(String coin_name, int coin_currentprice, double coin_change, double coin_transaction_value) {
        this.coin_name = coin_name;
        this.coin_currentprice = coin_currentprice;
        this.coin_change = coin_change;
        this.coin_transaction_value = coin_transaction_value;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public int getCoin_currentprice() {
        return coin_currentprice;
    }

    public void setCoin_currentprice(int coin_currentprice) {
        this.coin_currentprice = coin_currentprice;
    }

    public double getCoin_change() {
        return coin_change;
    }

    public void setCoin_change(double coin_change) {
        this.coin_change = coin_change;
    }

    public double getCoin_transaction_value() {
        return coin_transaction_value;
    }

    public void setCoin_transaction_value(double coin_transaction_value) {
        this.coin_transaction_value = coin_transaction_value;
    }
}
