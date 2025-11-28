package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.*;
import com.Entity.Role;
import com.Entity.User;
import com.Repository.UserRepository;

@Service
public class UserserviceImpl implements Userservices {

    @Autowired
    private UserRepository userRepo;

    @Override
    public String signUp(SignUpDto dto) {

        if (userRepo.existsByEmail(dto.getEmail())) {
            return "Email already exists!";
        }

        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhno(dto.getPhno());
        user.setPwd(dto.getPwd());
        user.setRole(Role.CITIZEN);

        userRepo.save(user);

        return "User Registered Successfully!";
    }

    @Override
    public LoginResposneDTO login(LoginRequestDTO loginRequest) {

        User user = userRepo.findByEmail(loginRequest.getEmail());

        if (user == null) {
            return new LoginResposneDTO("Invalid Email!", null, null);
        }

        if (!user.getPwd().equals(loginRequest.getPassword())) {
            return new LoginResposneDTO("Invalid Password!", null, null);
        }

        return new LoginResposneDTO("Login Successful!", user.getName(), user.getRole().name());
    }

    @Override
    public String forgetPassword(ForgetpasswordDto dto) {

        User user = userRepo.findByEmail(dto.getEmail());

        if (user == null) {
            return "Email not found!";
        }

        user.setPwd(dto.getNewPwd());
        user.setPwdUpdated("YES");

        userRepo.save(user);

        return "Password Updated Successfully!";
    }
}
