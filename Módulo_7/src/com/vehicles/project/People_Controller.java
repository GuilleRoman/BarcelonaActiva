package com.vehicles.project;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class People_Controller {
	People_Controller peopleController;
	VehicleController controller;
	public  static void createVehicleOwner() {
		Vehicle_Owner owner = new Vehicle_Owner();
		Vehicle.drivers.add(owner);
	}
	public static void createDriver() throws Exception {
		Driver driver = new Driver("Conductor"+Main.counter, "Generado Automáticamente", "21/08/1994");
		Vehicle.drivers.add(driver);
		Main.counter++;
	}
	public static void createDriver(String name, String lastName, String birthDate) throws Exception {
		Driver driver = new Driver(name, lastName, birthDate);
	}
	public void ownerIsDriver() throws Exception {
		String vehicleDriver = JOptionPane.showInputDialog(null, "¿Would the owner be the driver of the vehicle? (Yes/No)");
		if(vehicleDriver.matches("Yes")) {
			People_Controller.createDriver(Vehicle.drivers.get(0).getName(),Vehicle.drivers.get(0).getLastName(), 
				Vehicle.drivers.get(0).getBirthDate());
		}else {
			People_Controller.createDriver();
		}
	}
	
}
