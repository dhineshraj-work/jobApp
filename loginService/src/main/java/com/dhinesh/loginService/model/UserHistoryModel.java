package com.dhinesh.loginService.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_history")
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
	
	public UserHistoryModel() {
		
	}
	
	
	public UserHistoryModel(UserModel user, String otp, String lastLoginDate, String lastPasswordDate,
			String createDate) {
		super();
		this.user = user;
		this.otp = otp;
		this.lastLoginDate = lastLoginDate;
		this.lastPasswordDate = lastPasswordDate;
		this.createDate = createDate;
	}


	public Long getUhId() {
		return uhId;
	}


	public void setUhId(Long uhId) {
		this.uhId = uhId;
	}


	public UserModel getUser() {
		return user;
	}


	public void setUser(UserModel user) {
		this.user = user;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	public String getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(String lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	public String getLastPasswordDate() {
		return lastPasswordDate;
	}


	public void setLastPasswordDate(String lastPasswordDate) {
		this.lastPasswordDate = lastPasswordDate;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "UserHistory [uhId=" + uhId + ", user=" + user + ", otp=" + otp + ", lastLoginDate=" + lastLoginDate
				+ ", lastPasswordDate=" + lastPasswordDate + ", createDate=" + createDate + "]";
	}
	
}
