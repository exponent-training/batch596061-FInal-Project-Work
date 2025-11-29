package com.FinMediNexus.DTO;



import com.FinMediNexus.Enum.Role;

import lombok.Data;

@Data
public class LoginResponseDTO {
	
	private String message;
	
    private Integer userId;
    
    private Role role;

}
