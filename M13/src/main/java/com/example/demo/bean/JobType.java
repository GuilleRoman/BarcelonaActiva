package com.example.demo.bean;

public enum JobType {
	
	 DEVELOPER("DEVELOPER"), HR("HR"), QA("QA"), INDUSTRIAL("INDUSTRIAL"), MANAGER("MANAGER"), BUSSINESS("BUSSINESS"), IT("IT"), MAINTENANCE("MAINTENANCE");
	 private String position;
	 
	private JobType(String job) {
		this.position= job;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
}
