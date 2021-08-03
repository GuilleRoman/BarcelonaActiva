package com.vehicles.project;

import javax.swing.JOptionPane;

public class Vehicle_Owner extends Person {
	boolean insurance;
	boolean garage;
	
	public Vehicle_Owner() {
		String name = JOptionPane.showInputDialog(null, "Enter owner's name");
		this.name= name;
		String lastName = JOptionPane.showInputDialog(null, "Enter owner's last name");
		this.lastName= lastName;
		String birthDate = JOptionPane.showInputDialog(null, "Enter owner's birth date");
		this.birthDate= birthDate;
		String checkInsurance = JOptionPane.showInputDialog(null, "¿Do you have insurance? (Yes/No)");
			if(checkInsurance.matches("Yes")) {
				this.insurance= true;
			}else {
				this.insurance = false;
		}
		String checkGarage = JOptionPane.showInputDialog(null, "¿Do you have garage? (Yes/No)");
			if(checkGarage.matches("Yes")) {
				this.garage= true;
			}else {
				this.garage = false;
			}
	}
	public String getName() {
		return this.name;
	}
	public String getLastName() {
		return this.lastName;
	}
}
