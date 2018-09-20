package com.metacube.training.model;

import java.io.InputStream;
import java.util.Date;

public class Project {

	private int id;
	private String description;
	private Date startDate;
	private Date endDate;
	private InputStream logo;
	
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
	public InputStream getLogo() {
		return logo;
	}
	public void setLogo(InputStream logo) {
		this.logo = logo;
	}
}
