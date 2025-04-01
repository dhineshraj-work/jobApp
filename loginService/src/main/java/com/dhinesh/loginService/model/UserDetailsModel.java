package com.dhinesh.loginService.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetailsModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@JsonIgnore
	private Integer userDetailsId;
	
	@OneToOne
	@JoinColumn(name="user_id", referencedColumnName = "userId")
	@JsonIgnore
	private UserModel user;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private int age;
	private String currentStatus;
	@ElementCollection
	private List<String> skills;
	private Long contactNumber;
	
	public UserDetailsModel() {
		
	}

	

	public UserDetailsModel(UserModel user, String firstName, String middleName, String lastName, int age,
			String currentStatus, List<String> skills, Long contactNumber) {
		super();
		this.user = user;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.currentStatus = currentStatus;
		this.skills = skills;
		this.contactNumber = contactNumber;
	}



	public UserDetailsModel(Integer userDetailsId, UserModel user, String firstName, String middleName, String lastName, int age,
			String currentStatus, List<String> skills, Long contactNumber) {
		super();
		this.userDetailsId = userDetailsId;
		this.user = user;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.age = age;
		this.currentStatus = currentStatus;
		this.skills = skills;
		this.contactNumber = contactNumber;
	}
	
	public Integer getUserDetailsId() {
		return userDetailsId;
	}
	public void setUserDetailsId(Integer userDetailsId) {
		this.userDetailsId = userDetailsId;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

}
