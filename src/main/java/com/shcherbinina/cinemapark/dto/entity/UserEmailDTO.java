package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserEmailDTO {
    @NotEmpty
    @Email
    private String email;
}
