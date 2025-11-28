package com.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AuthServ.AuthServices;
import com.Dto.ForgetPasswordDto;
import com.Dto.LoginReqDto;
import com.Dto.SignUpDto;
import com.Entity.User;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private AuthServices as;

	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto sUDto){
		 String msg = as.signUp(sUDto);
		 return ResponseEntity.ok(msg);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginReqDto lRDto){
		User user = as.LoginReqDto(lRDto);
		return ResponseEntity.ok(user);
		
	}
	
	@PostMapping("/forget-password")
    public ResponseEntity<String> forgetPassword(@Valid @RequestBody ForgetPasswordDto dto) {
        String msg = as.forgetPassword(dto);
        return ResponseEntity.ok(msg);
    }
	
	
}
