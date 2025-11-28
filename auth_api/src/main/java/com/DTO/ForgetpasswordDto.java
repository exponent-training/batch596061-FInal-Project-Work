package com.DTO;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class ForgetpasswordDto {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6)
    private String newPwd;
}
