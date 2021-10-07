package com.example.demo.bean;

public class Employee {
	
//	@Id
//	@Column(name="id")
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private JobType job;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public JobType getJob() {
		return job;
	}

	public void setJob(JobType job) {
		this.job = job;
	}

	public Employee(int id, String name, JobType job) {
		super();
		this.name = name;
		this.id = id;
		this.job = job;
		
	}
	
	
	
}
