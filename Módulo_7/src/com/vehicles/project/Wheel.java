package com.vehicles.project;

import javax.swing.JOptionPane;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}
	public Wheel() {
		String brandInput = JOptionPane.showInputDialog(null, "Enter wheel's brand");
		this.brand = brandInput;
		String diameterInput = JOptionPane.showInputDialog(null, "Enter wheel's diameter.");
		this.diameter =  Double.parseDouble(diameterInput);
	}
	
}
