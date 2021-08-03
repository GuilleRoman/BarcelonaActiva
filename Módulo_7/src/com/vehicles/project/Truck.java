package com.vehicles.project;

import javax.swing.JOptionPane;

public class Truck extends Vehicle {

	public Truck(String plate, String brand, String color) {
		super(plate, brand, color);
		// TODO Auto-generated constructor stub
	}

	public Truck() throws Exception {
		// TODO Auto-generated constructor stub
		String plateInput = JOptionPane.showInputDialog(null, "Enter truck's plate");
		this.plate = plateInput;
		if(!plateInput.matches("(^\\d{4})(\\w{2,3})"))
		throw new Exception();
		String brandInput = JOptionPane.showInputDialog(null, "Enter truck's brand.");
		this.brand =  brandInput;
		String colorInput = JOptionPane.showInputDialog(null, "Enter truck's color");
		this.color = colorInput;
		this.owner = (Vehicle_Owner)drivers.get(0);
		//this.owner= new Vehicle_Owner();
		//drivers.add(owner);
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

}
