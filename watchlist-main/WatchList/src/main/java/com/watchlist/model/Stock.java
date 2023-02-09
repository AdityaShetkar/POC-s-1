package com.watchlist.model;

public class Stock {
    private int stock_id;
    private String stock_name;
    private int stock_price;
    private String listedOn;
    private boolean status = true;

    public Stock() {
    }

    public Stock(int stock_id, String stock_name, int stock_price, String listedOn, boolean status) {
        this.stock_id = stock_id;
        this.stock_name = stock_name;
        this.stock_price = stock_price;
        this.listedOn = listedOn;
        this.status = status;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public int getStock_price() {
        return stock_price;
    }

    public void setStock_price(int stock_price) {
        this.stock_price = stock_price;
    }

    public String getListedOn() {
        return listedOn;
    }

    public void setListedOn(String listedOn) {
        this.listedOn = listedOn;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
