package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserPasswordDTO {
    @NotNull
    @Size(min = 5, max = 10, message = "Password should be from 5 to 10 symbols")
    private String newPassword;

    @NotNull
    private String oldPassword;
}
