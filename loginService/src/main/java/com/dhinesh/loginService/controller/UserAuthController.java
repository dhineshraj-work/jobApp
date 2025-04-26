package com.dhinesh.loginService.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhinesh.loginService.dto.EmailRequest;
import com.dhinesh.loginService.dto.OTPRequest;
import com.dhinesh.loginService.dto.UserDetailsDto;
import com.dhinesh.loginService.service.UserAuthService;

@RestController
@RequestMapping("/job/auth/user")
public class UserAuthController {
	
	@Autowired
	UserAuthService userService;

	@PostMapping("update")
	public ResponseEntity<?> updateDetails(Principal principal, @RequestBody UserDetailsDto user){
		return userService.updateDetails(principal.getName(), user);
	}
	
	@PostMapping("password")
	public ResponseEntity<Object> resetPassword(@RequestBody EmailRequest request){
		return userService.getPasswordResetOTP(request.getEmail());
	}
	
	@PostMapping("password/otp")
	public ResponseEntity<Object> validateOTP(@RequestBody OTPRequest otpRequest){
		return userService.vaildateOTP(otpRequest.getEmail(), otpRequest.getOtp(), otpRequest.getPassword());
	}
}
