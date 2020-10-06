package com.shcherbinina.cinemapark.dto.entity;

import com.shcherbinina.cinemapark.dao.entity.Role;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class UserDTO {
    private int id;
    @NotEmpty(message="Name is required")
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotNull
    @Size(min = 5, max = 10, message = "Password should be from 5 to 10 symbols")
    private String password;
    @NotBlank
    @Email
    private String email;
    private BigDecimal amountMoney;
    private Set<Role> roles;
}
