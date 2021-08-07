package com.vehicles.project;

import java.util.List;

import javax.swing.JOptionPane;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	public Bike() throws Exception {
		String plateInput = JOptionPane.showInputDialog(null, "Enter bike's plate");
		this.plate = plateInput;
		if(!plateInput.matches("(^\\d{4})(\\w{2,3})"))
		throw new Exception();
		String brandInput = JOptionPane.showInputDialog(null, "Enter bike's brand.");
		this.brand =  brandInput;
		String colorInput = JOptionPane.showInputDialog(null, "Enter bike's color");
		this.color = colorInput;
		this.owner = (Vehicle_Owner)drivers.get(0);
		boolean loop= true;
		while(loop){
			String moreDrivers = JOptionPane.showInputDialog(null, "¿Would you like to add more drivers for this vehicle? (yes/no)");
			if(moreDrivers.matches("Yes")) {
				People_Controller.createDriver();
				
			}else {
				break;
			}
		}
	}
	public static void addWheels(List<Wheel> frontWheels) throws Exception {
		addTwoWheels(frontWheels);
	}

	public static void addTwoWheels(List<Wheel> wheels) throws Exception {
		Wheel frontWheel = wheels.get(0);
		Wheel backWheel = wheels.get(1);
		if (!frontWheel.equals(backWheel))
			throw new Exception();
		wheels.add(frontWheel);
		wheels.add(backWheel);
	}

}
