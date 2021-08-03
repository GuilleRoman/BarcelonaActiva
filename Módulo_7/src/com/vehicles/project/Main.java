package com.vehicles.project;

import javax.swing.JOptionPane;

public class Main {
	
	public static VehicleController controller = new VehicleController();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String choiceToCreate= JOptionPane.showInputDialog(null, "¿Which vehicle would you like to create? (Car/Bike/Truck)");
		if(choiceToCreate.matches("Car")) {
			controller.createCar();
			controller.createWheelsForCar();
		} else if (choiceToCreate.matches("Bike")) {
			controller.createBike();
			controller.createWheelsForBike();
		}  else if (choiceToCreate.matches("Truck")) {
			controller.createTruck();
			controller.createWheelsForCar();
		} 
		
		for(Vehicle e:VehicleController.vehicles) {
			System.out.println(e.getBrand()+" "+ e.getColor()+" " +e.plate);
		}
		
		
		
		
		
	}

}
