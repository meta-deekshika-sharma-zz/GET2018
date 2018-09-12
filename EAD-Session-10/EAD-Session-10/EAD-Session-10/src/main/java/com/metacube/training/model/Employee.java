package com.metacube.training.model;

import java.io.InputStream;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {

	private String emp_code;
	private String firstName;
	private String middleName;
	private String lastName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String primaryContactNo;
	private String secondaryContactNo;
	private String emailId;
	private String skypeId;
	private InputStream profilePicture;
	private String password;
	private boolean enabled;

	public String getCode() {
		return emp_code;
	}
	public void setCode(String emp_code) {
		this.emp_code = emp_code;
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPrimaryContactNo() {
		return primaryContactNo;
	}
	public void setPrimaryContactNo(String primaryContactNo) {
		this.primaryContactNo = primaryContactNo;
	}
	public String getSecondaryContactNo() {
		return secondaryContactNo;
	}
	public void setSecondaryContactNo(String secondaryContactNo) {
		this.secondaryContactNo = secondaryContactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public InputStream getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(InputStream profilePicture) {
		this.profilePicture = profilePicture;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	
}
