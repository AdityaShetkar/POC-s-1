package com.watchlist.model;

import java.util.Set;

public class WatchlistData {
    private int watchlistId;
    private int userId;
    private String type;
    private Set<Stock> stockList;

    public WatchlistData() {
    }

    public WatchlistData(int watchlistId, int userId, String type, Set<Stock> stockList) {
        this.watchlistId = watchlistId;
        this.userId = userId;
        this.type = type;
        this.stockList = stockList;
    }

    public int getWatchlistId() {
        return watchlistId;
    }

    public void setWatchlistId(int watchlistId) {
        this.watchlistId = watchlistId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(Set<Stock> stockList) {
        this.stockList = stockList;
    }
}
