package com.vehicles.project;

import javax.swing.JOptionPane;

public class Wheel {
	private String brand;
	private double diameter;
	
	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	//this method creates asks the user for the info while also checks that the diameter is correct.
	public Wheel() throws Exception {
		String brandInput = JOptionPane.showInputDialog(null, "Enter wheel's brand");
		this.brand = brandInput;
		String diameterInput = JOptionPane.showInputDialog(null, "Enter wheel's diameter.");
		this.diameter =  Double.parseDouble(diameterInput);
		double proveDiameter= this.diameter;
		if(proveDiameter <0.4 || proveDiameter>4.0)
			throw new Exception();
		
	}
	
}
