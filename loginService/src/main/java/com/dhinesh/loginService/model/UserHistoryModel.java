package com.dhinesh.loginService.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHistoryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uhId;

	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName = "userId")
	@JsonIgnore
	private UserModel user;
	
	private String otp;
	private String lastLoginDate;
	private String lastPasswordDate;
	private String createDate;
}
