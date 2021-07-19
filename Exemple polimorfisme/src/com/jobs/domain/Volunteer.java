package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	public static String description;

	public String getDescription() {
		return description;
	}
	public static void setDescription(String description) {
		Volunteer.description = description;
	}
	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		this.address = address;
		this.name = name;
		this.phone = phone;
		Volunteer.description = description;
		//TODO
	}
	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		this.address = address;
		this.name = name;
		this.phone = phone;
		
		//TODO
	}

	
	@Override
	public void pay() {
		//TODO
		
	}

}
