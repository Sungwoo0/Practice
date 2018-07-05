package com.example.sungwoo.joinactivity.Model;

public class CoinDetail {
    private double trade_price;
    private String change;
    //거래대
    private double acc_trade_price_24h;
    //전일대비
    private double change_rate;
    private String market;

    public CoinDetail(double trade_price, String change, double acc_trade_price_24h, double change_rate, String market) {
        this.trade_price = trade_price;
        this.change = change;
        this.acc_trade_price_24h = acc_trade_price_24h;
        this.change_rate = change_rate;
        this.market = market;
    }

    public double getTrade_price() {
        return trade_price;
    }

    public void setTrade_price(double trade_price) {
        this.trade_price = trade_price;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public double getAcc_trade_price_24h() {
        return acc_trade_price_24h;
    }

    public void setAcc_trade_price_24h(double acc_trade_price_24h) {
        this.acc_trade_price_24h = acc_trade_price_24h;
    }

    public double getChange_rate() {
        return change_rate;
    }

    public void setChange_rate(double change_rate) {
        this.change_rate = change_rate;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }
}
