package com.vehicles.project;

import java.util.List;

import javax.swing.JOptionPane;

public class Car extends Vehicle {
	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	//This constructor allows to ask the user for the data needed, then makes some checks in the input.
	public Car() throws Exception {
		String plateInput = JOptionPane.showInputDialog(null, "Enter car's plate");
		this.plate = plateInput;
		if(!plateInput.matches("(^\\d{4})(\\w{2,3})"))
		throw new Exception();
		String brandInput = JOptionPane.showInputDialog(null, "Enter car's brand.");
		this.brand =  brandInput;
		String colorInput = JOptionPane.showInputDialog(null, "Enter car's color");
		this.color = colorInput;
		this.owner = (Vehicle_Owner)drivers.get(0);
		//this.owner= new Vehicle_Owner();
	//	drivers.add(owner);
		boolean loop= true;
		while(loop){
			String moreDrivers = JOptionPane.showInputDialog(null, "¿Would you like to add more drivers for this vehicle? (yes/no)");
			if(moreDrivers.matches("Yes")) {
				People_Controller.createDriver();
			}else {
				loop=false;
			}
		}
		
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
