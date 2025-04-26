package com.dhinesh.loginService.dto;

import java.util.List;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class UserDetailsDto {

	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private String currentStatus;
	private List<String> skills;
	private Long contactNumber;
}
