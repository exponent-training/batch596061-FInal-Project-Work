package com.DTO;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class SignUpDto {

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private Long phno;

    @NotBlank
    @Size(min = 6)
    private String pwd;
}
