package com.metacube.training.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PreSignUp {

	private String code;

	private String firstName;

	private String middleName;

	private String lastName;

	private String gender;

	private String emailId;

	private String reportingMgr;

	private String teamLead;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dob;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date doj;

	private String password;

	private Integer projectId;

	private Integer jobCode;

	private double totalExp;

	public Integer getJobCode() {
		return jobCode;
	}

	public void setJobCode(Integer jobCode) {
		this.jobCode = jobCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getReportinhMgr() {
		return reportingMgr;
	}

	public void setReportinhMgr(String reportingMgr) {
		this.reportingMgr = reportingMgr;
	}

	public String getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public double getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(double totalExp) {
		this.totalExp = totalExp;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getReportingMgr() {
		return reportingMgr;
	}

	public void setReportingMgr(String reportingMgr) {
		this.reportingMgr = reportingMgr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
