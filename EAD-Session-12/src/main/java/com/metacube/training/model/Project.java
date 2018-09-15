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
@Table(name = "ProjectMaster")
public class Project {

	@Id
	@Column(name = "project_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "start_date")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "end_date")
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
//	private InputStream logo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
//	public InputStream getLogo() {
//		return logo;
//	}
//	public void setLogo(InputStream logo) {
//		this.logo = logo;
//	}
}
