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
		Driver driver = new Driver("Guillermo", "Román Medrano", "21/08/1994");
		Vehicle.drivers.add(driver);
	}
	public static void createDriver(String name, String lastName, String birthDate) throws Exception {
		Driver driver = new Driver(name, lastName, birthDate);
	}
	/*public String creationSecuence() throws Exception {
		People_Controller.createVehicleOwner();
		String choiceToCreate= JOptionPane.showInputDialog(null, "¿Which vehicle would you like to create? (Car/Bike/Truck)");
			if(choiceToCreate.matches("Car")) {
				controller.createCar();
				controller.createWheelsForCar();
	}		 else if (choiceToCreate.matches("Bike")) {
				controller.createBike();
				controller.createWheelsForBike();
	} 		 else if (choiceToCreate.matches("Truck")) {
				controller.createTruck();
				controller.createWheelsForCar();
	} 
	String vehiculos="";
	String conductores="";
		
		for(Vehicle e:VehicleController.vehicles) {
			System.out.println(e.getBrand()+" "+ e.getColor()+" " +e.plate);
			vehiculos = e.getBrand()+" "+ e.getColor()+" " +e.plate;
			vehiculos= vehiculos+ "\n" + e.getBrand()+" "+ e.getColor()+" " +e.plate;
	}
	
		for(Person d: Vehicle.drivers) {
			System.out.println(d.getName()+" "+  d.getLastName()+ " " + d.getBirthDate());
			conductores = d.getName()+" "+  d.getLastName()+ " " + d.getBirthDate();
			conductores= conductores+ "\n" + d.getName()+" "+  d.getLastName()+ " " + d.getBirthDate();
	}
		return vehiculos + "n"+ conductores;
	}*/
}
