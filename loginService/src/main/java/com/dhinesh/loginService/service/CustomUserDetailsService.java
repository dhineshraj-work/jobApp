package com.dhinesh.loginService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dhinesh.loginService.model.UserModel;
import com.dhinesh.loginService.model.UserPrincipal;
import com.dhinesh.loginService.repo.UserRepo;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserModel user = userRepo.findByEmail(email).orElseThrow();
		return new UserPrincipal(user);
	}
}
