package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JobTitleMaster")
public class Job {

	@Id
	@Column(name = "job_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column(name = "job_title")
	private String title;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
