package com.dhinesh.loginService.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dhinesh.loginService.dto.UserDetailsDto;
import com.dhinesh.loginService.model.UserDetailsModel;
import com.dhinesh.loginService.model.UserHistoryModel;
import com.dhinesh.loginService.model.UserModel;
import com.dhinesh.loginService.repo.UserRepo;

@Service
public class UserAuthService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public ResponseEntity<?> updateDetails(String username, UserDetailsDto user)throws UsernameNotFoundException {
		try {
			
			UserModel userModel = userRepo.findByEmail(username).orElseThrow();
			
			if(user==null) {
				return ResponseEntity.status(404).body("User data is missing");
			}
			
			UserDetailsModel userDetails = new UserDetailsModel();			
			userDetails.setUser(userModel);
			userDetails.setFirstName(user.getFirstName());
			userDetails.setMiddleName(user.getMiddleName());
			userDetails.setLastName(user.getLastName());
			userDetails.setContactNumber(user.getContactNumber());
			userDetails.setCurrentStatus(user.getCurrentStatus());
			userDetails.setSkills(user.getSkills());
			userDetails.setAge(user.getAge());
			
			userModel.setUserDetails(userDetails);
			
			userRepo.save(userModel);
			
			return ResponseEntity.ok(userModel);
			
		}catch(Exception e) {
			return ResponseEntity.status(500).body("Something went wrong   " + e);
		}
	}
	
	public ResponseEntity<Object> getPasswordResetOTP(String email) {
		try {
			if(!userRepo.existsByEmail(email)) {
				return ResponseEntity.status(404).body("User not found for the email provided");
			}
			UserModel user = userRepo.findByEmail(email).orElse(null);
			String otp = generateOTP();
			
			UserHistoryModel userHistory = user.getUserHistory();
			userHistory.setOtp(otp);
			user.setUserHistory(userHistory);
			
			userRepo.save(user);
			
			return ResponseEntity.ok(otp);
			
		}catch(Exception e) {
			return ResponseEntity.status(500).body("Something went wrong  "+e);
		}
	}

	public ResponseEntity<Object> vaildateOTP(String email, String otp, String password) {
		try {
			if(!userRepo.existsByEmail(email)) {
				return ResponseEntity.status(404).body("User not found for the email provided");
			}
			UserModel user = userRepo.findByEmail(email).orElse(null);
			if(user.getUserHistory().getOtp().equals(otp)) {
				user.setPassword(passwordEncoder.encode(password));
				user.getUserHistory().setLastPasswordDate(currentDate());
				userRepo.save(user);
				return ResponseEntity.ok("OTP validated & Password changed");
			}
			return ResponseEntity.status(400).body("Not a valid OTP");
			
		}catch(Exception e) {
			return ResponseEntity.status(500).body("Something went wrong  "+e);
		}
	}
	
	
	public String generateOTP() {
		
		Random random = new Random();
		
		int otp = 100000 + random.nextInt(999999);
		
		return String.valueOf(otp);
	}
	
	public String currentDate() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
}
