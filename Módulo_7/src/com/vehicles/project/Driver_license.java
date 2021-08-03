package com.vehicles.project;
import com.vehicles.project.*;
public class Driver_license {
	int id;
	String license_type;
	String fullName;
	String expire_date;
	public Driver_license(int id, String license_type, String fullName, String expire_date) throws Exception {
		this.id=id;
		this.license_type= license_type;
		if (!license_type.equalsIgnoreCase("B"))
			throw new Exception();
		this.fullName= fullName;
		this.expire_date= expire_date;
		
	}
}
