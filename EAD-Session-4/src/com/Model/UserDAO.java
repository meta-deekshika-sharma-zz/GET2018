package com.Model;

public class UserDAO {

	private String firstName;
	private String lastName;
	private String email;
	private java.util.Date dob;
	private String password;
	private String contactNumber;
	private String organization;
	private String imagePath;

	public UserDAO(String firstName, String lastName, String email,
			java.util.Date dob, String password, String contactNumber,
			String organization, String imagePath) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.contactNumber = contactNumber;
		this.organization = organization;
		this.imagePath = imagePath;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public java.util.Date getDob() {
		return dob;
	}

	public void setDob(java.util.Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
