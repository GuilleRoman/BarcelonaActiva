package com.vehicles.project;

import javax.swing.JOptionPane;

public class Main {
	
	public static VehicleController controller = new VehicleController();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String choiceToCreate= JOptionPane.showInputDialog(null, "¿Which vehicle would you like to create? (Car/Bike)");
		if(choiceToCreate.matches("Car")) {
			controller.createCar();
			controller.createWheelsForCar();
		} else if (choiceToCreate.matches("Bike")) {
			controller.createBike();
			controller.createWheelsForBike();
		}
		
		
		
		
		
	}

}
