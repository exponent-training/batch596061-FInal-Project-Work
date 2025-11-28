package com.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.DTO.*;
import com.Service.Userservices;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private Userservices userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto request) {
        return ResponseEntity.ok(userService.signUp(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@Valid @RequestBody LoginRequestDTO loginRequest) {
        return ResponseEntity.ok(userService.login(loginRequest));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgetpasswordDto dto) {
        return ResponseEntity.ok(userService.forgetPassword(dto));
    }
}
