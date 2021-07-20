package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	public static String description;
	private boolean ayuda;
	public String getDescription() {
		return description;
	}
	public boolean getAyuda() {
		return this.ayuda;
	}
	public static void setDescription(String description) {
		Volunteer.description = description;
	}
	public Volunteer(String name, String address, String phone, String description, boolean ayuda) throws Exception {
		super(name, address, phone);
		this.address = address;
		this.name = name;
		this.phone = phone;
		Volunteer.description = description;
		this.ayuda= ayuda;
		
		//TODO
	}
	public Volunteer(String name, String address, String phone, boolean ayuda) throws Exception {
		super(name, address, phone);
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.ayuda= ayuda;
		
		//TODO
	}

	
	@Override
	public void pay() throws Exception{
		if(this.getAyuda()) {
			totalPaid= 300;
		}else {
			totalPaid= 0;
		}
		
	}
	@Override
	public void payBonus() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
