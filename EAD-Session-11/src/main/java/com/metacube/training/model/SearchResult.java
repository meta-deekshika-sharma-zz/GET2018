package com.metacube.training.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Employee")
@SecondaryTable(name = "JobDetails")
public class SearchResult {

	@Id
	@Column(name = "emp_code", table = "Employee", nullable = false)
	private String code;
	
	@Column(name = "first_name", table = "Employee")
	private String firstName;
	
	@Column(name = "middle_name", table = "Employee")
	private String middleName;
	
	@Column(name = "last_name", table = "Employee")
	private String lastName;
	
	@Column(name = "gender", table = "Employee")
	private String gender;
	
	@Column(name = "primary_contact_no", table = "Employee")
	private String primaryContactNo;
	
	@Column(name = "secondary_contact_no", table = "Employee")
	private String secondaryContactNo;
	
	@Column(name = "skype_id", table = "Employee")
	private String skypeId;
	
	@Column(name = "enabled", table = "Employee")
	private boolean enabled;
	
	@Column(name = "email_id", table = "Employee")
	private String emailId;
	
	@Column(name = "reporting_mgr", table = "JobDetails")
	private String reportingMgr;
	
	@Column(name = "team_lead", table = "JobDetails")
	private String teamLead;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "dob", table = "Employee")
	private Date dob;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_joining", table = "JobDetails")
	private Date doj;
	
	@Column(name = "password", table = "Employee")
	private String password;
	
	@Column(name = "curr_project_id", table = "JobDetails")
	private Integer projectId;
	
	@Column(name = "job_code", table = "JobDetails")
	private Integer jobCode;
	
	@Column(name = "total_exp", table = "JobDetails")
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
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
