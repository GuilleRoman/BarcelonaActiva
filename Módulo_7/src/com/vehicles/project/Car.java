package com.vehicles.project;

import java.util.List;

import javax.swing.JOptionPane;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	public Car() {
		String plateInput = JOptionPane.showInputDialog(null, "Enter the plate");
		this.plate = plateInput;
		String brandInput = JOptionPane.showInputDialog(null, "Enter the brand.");
		this.brand =  brandInput;
		String colorInput = JOptionPane.showInputDialog(null, "Enter the color");
		this.color = colorInput;
	}
	

	public static void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public static void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		wheels.add(leftWheel);
		wheels.add(rightWheel);
	}
	
}
