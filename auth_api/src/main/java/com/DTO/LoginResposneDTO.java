package com.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResposneDTO {

    private String message;
    private String userName;
    private String role;
}
