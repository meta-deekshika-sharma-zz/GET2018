package com.entity;

/**
 * This class will have the Advertisement entity which include title,
 * description of a advertisement into a particular category
 * 
 * @author Deekshika Sharma
 */
public class Advertisement {

	private int id;
	private String title;
	private String description;
	private int categoryID;

	public Advertisement() {
	}

	public Advertisement(int id, String title, String description,
			int categoryID) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.categoryID = categoryID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
