package com.dhinesh.loginService.dto;

import org.springframework.stereotype.Component;

@Component
public class OTPRequest {
	
	private String email;
	private String otp;
	private String password;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
