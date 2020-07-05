package com.shcherbinina.cinemapark.controllers;

import com.shcherbinina.cinemapark.dto.entity.AccountDTO;
import com.shcherbinina.cinemapark.dto.services.IAccountService;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InsufficientFundsException;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InvalidWithdrawalAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/replenish", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> replenishAccount(@RequestBody AccountDTO accountDTO) throws InvalidWithdrawalAmountException {
        accountService.sendMoney(accountDTO);
        return new ResponseEntity<>("Replenished successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> pay(@RequestBody AccountDTO accountDTO) throws InsufficientFundsException {
        accountService.getMoney(accountDTO);
        return new ResponseEntity<>("Paid successfully", HttpStatus.CREATED);
    }
}
