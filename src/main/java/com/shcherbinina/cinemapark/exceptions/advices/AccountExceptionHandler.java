package com.shcherbinina.cinemapark.exceptions.advices;

import com.shcherbinina.cinemapark.exceptions.businessExceptions.InsufficientFundsException;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InvalidWithdrawalAmountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AccountExceptionHandler {
    @ExceptionHandler({InsufficientFundsException.class})
    public ResponseEntity<Object> handleInsufficientFundsException(InsufficientFundsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InvalidWithdrawalAmountException.class})
    public ResponseEntity<Object> handleInvalidWithdrawalAmountException(InvalidWithdrawalAmountException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
