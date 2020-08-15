package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class MoneyAccountDTO {
    @NotEmpty
    private String amountMoney;
}
