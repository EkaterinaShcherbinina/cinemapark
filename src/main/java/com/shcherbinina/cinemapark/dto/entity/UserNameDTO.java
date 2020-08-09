package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserNameDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
}
