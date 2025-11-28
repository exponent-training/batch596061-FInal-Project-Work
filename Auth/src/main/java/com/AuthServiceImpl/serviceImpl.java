package com.AuthServiceImpl;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AuthRepository.UserRepo;
import com.AuthServ.AuthServices;
import com.Dto.SignUpDto;
import com.Dto.ForgetPasswordDto;
import com.Dto.LoginReqDto;
import com.Entity.User;
@Service
public class serviceImpl implements AuthServices{
	@Autowired
	private UserRepo ur;

	@Override
	public String signUp(@Valid SignUpDto sUDto) {
		
		User user=new User();
		   user.setName(sUDto.getName());
	        user.setEmail(sUDto.getEmail());
	        user.setPwd(sUDto.getPwd());
	        user.setPwdUpdated(sUDto.getPwd());
	        user.setPhno(sUDto.getPhno());
	        user.setRole(sUDto.getRole());
		ur.save(user);
		if(user!=null)
			return "signUp successful";
		else
			return "signUp Fail";
	}


	@Override
	public User LoginReqDto(LoginReqDto lRDto) {
	 User user = ur.findByName(lRDto.getName().trim());
	    if(user != null) {
	       
	        if(user.getPwd().trim().equals(lRDto.getPwd().trim())) {
	            return user;
	        } else {
	            throw new RuntimeException("Invalid password");
	        }
	    } else {
	        throw new RuntimeException("User not found");
	    }
	}
	
	 @Override
	    public String forgetPassword(@Valid ForgetPasswordDto forgetPasswordDto) {
	        User user = ur.findByEmail(forgetPasswordDto.getEmail().trim());
	        if(user == null) {
	            return "Email not found";
	        }
	        user.setPwd(forgetPasswordDto.getNewPwd());
	        user.setPwdUpdated(forgetPasswordDto.getNewPwd());
	        ur.save(user);
	        return "Password updated successfully";
	    }


	
}
