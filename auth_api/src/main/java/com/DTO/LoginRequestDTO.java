package com.DTO;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
