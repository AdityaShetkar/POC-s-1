package com.watchlist.model;

public class User {
    private int userId;
    private String username;
    private int watchlistCount;

    public User() {
    }

    public User(int userId, String username, int watchlistCount) {
        this.userId = userId;
        this.username = username;
        this.watchlistCount = watchlistCount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getWatchlistCount() {
        return watchlistCount;
    }

    public void setWatchlistCount(int watchlistCount) {
        this.watchlistCount = watchlistCount;
    }
}
