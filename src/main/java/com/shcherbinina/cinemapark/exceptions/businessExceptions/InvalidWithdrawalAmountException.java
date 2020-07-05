package com.shcherbinina.cinemapark.exceptions.businessExceptions;

public class InvalidWithdrawalAmountException extends Exception{
    private String message = "Invalid withdrawal amount";

    @Override
    public String getMessage() {
        return message;
    }
}
