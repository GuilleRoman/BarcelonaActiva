package com.example.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Anotaciones para backend con JPA
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@Column(name="id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(name="job")
	@Enumerated(EnumType.STRING)
	private JobType job;
	@GeneratedValue(strategy=GenerationType.AUTO)
	private double salary;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobType getJob() {
		return this.job;
	}

	public void setJob(JobType job) {
		this.job = job;
	}

	public Employee(int id, String name, JobType job) {
		super();
		this.name = name;
		this.id = id;
		this.job =  job;
		if(this.job == JobType.BUSSINESS) salary = 60000; 
		else if(this.job == JobType.DEVELOPER) salary = 75000; 
		else if(this.job == JobType.HR) salary = 45000; 
		else if(this.job == JobType.INDUSTRIAL) salary = 65000; 
		else if(this.job == JobType.IT) salary = 60000; 
		else if(this.job == JobType.MANAGER) salary = 85000; 
		else if(this.job == JobType.QA) salary = 55000; 
		else salary = 30000; 
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
