package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * @author Deekshika Sharma
 * This class will used for employee class representation
 */
@Entity
@Table(name = "EmployeeSkill")
public class EmployeeSkill {

	@Id
	@Column(name = "emp_skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "emp_code")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private Skill skill;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
