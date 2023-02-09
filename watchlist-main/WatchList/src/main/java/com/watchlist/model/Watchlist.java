package com.watchlist.model;

public class Watchlist {
    private int watchlistId;
    private int userId;
    private String watchlistName;
    private int numberOfStocks;
    private String type;

    public Watchlist() {
    }

    public Watchlist(int watchlistId, int userId, String watchlistName, int numberOfStocks, String type) {
        this.watchlistId = watchlistId;
        this.userId = userId;
        this.watchlistName = watchlistName;
        this.numberOfStocks = numberOfStocks;
        this.type = type;
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

    public String getWatchlistName() {
        return watchlistName;
    }

    public void setWatchlistName(String watchlistName) {
        this.watchlistName = watchlistName;
    }

    public int getNumberOfStocks() {
        return numberOfStocks;
    }

    public void setNumberOfStocks(int numberOfStocks) {
        this.numberOfStocks = numberOfStocks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
