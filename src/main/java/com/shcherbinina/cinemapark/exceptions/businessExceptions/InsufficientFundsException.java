package com.shcherbinina.cinemapark.exceptions.businessExceptions;

public class InsufficientFundsException extends Exception {
    private String message = "Insufficient funds in the account";

    @Override
    public String getMessage() {
        return message;
    }
}
