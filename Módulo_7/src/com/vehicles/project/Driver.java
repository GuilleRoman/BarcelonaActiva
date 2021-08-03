package com.vehicles.project;

import javax.swing.JOptionPane;

public class Driver extends Person {
	Driver_license license;
	
	public Driver(String name, String lastName, String birthDate) throws Exception {
		//String name = JOptionPane.showInputDialog(null, "Enter owner's name");
		this.name= name;
		//String lastName = JOptionPane.showInputDialog(null, "Enter owner's last name");
		this.lastName= lastName;
		//String birthDate = JOptionPane.showInputDialog(null, "Enter owner's birth date");
		this.birthDate= birthDate;
		this.license= new Driver_license(234234123, "B", name+" "+lastName, birthDate);
	}
	public String getName() {
		return this.name;
	}
	public String getLastName() {
		return this.lastName;
	}
}

