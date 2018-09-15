package com.metacube.training.model;

import java.io.InputStream;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "emp_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String emp_code;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "dob")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "primary_contact_no")
	private String primaryContactNo;
	
	@Column(name = "secondary_contact_no")
	private String secondaryContactNo;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "skype_id")
	private String skypeId;
	
	
	//private InputStream profilePicture;
	@Column(name = "password")
	private String password;
	
	@Column(name = "enabled")
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
//	public InputStream getProfilePicture() {
//		return profilePicture;
//	}
//	public void setProfilePicture(InputStream profilePicture) {
//		this.profilePicture = profilePicture;
//	}
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
