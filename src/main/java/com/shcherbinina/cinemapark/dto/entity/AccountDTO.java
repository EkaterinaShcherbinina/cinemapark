package com.shcherbinina.cinemapark.dto.entity;


public class AccountDTO {
    private int userId;
    private double amountMoney;

    public AccountDTO(int userId, double amountMoney) {
        this.userId = userId;
        this.amountMoney = amountMoney;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(double amountMoney) {
        this.amountMoney = amountMoney;
    }
}
