package com.vehicles.project;

import javax.swing.JOptionPane;

public class Main {
	
	public static VehicleController controller = new VehicleController();
	public static People_Controller peopleController = new People_Controller();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		peopleController.createVehicleOwner();
		
		
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
		String vehicleDriver = JOptionPane.showInputDialog(null, "¿Would the owner be the driver of the vehicle? (Yes/No)");
			if(vehicleDriver.matches("Yes")) {
				peopleController.createDriver(People_Controller.people.get(0).getName(),People_Controller.people.get(0).getLastName(), 
					People_Controller.people.get(0).getBirthDate());
			}else {
				peopleController.createDriver();
			}
		
			
		for(Vehicle e:VehicleController.vehicles) {
			System.out.println(e.getBrand()+" "+ e.getColor()+" " +e.plate);
		}
		
		for(Person d: People_Controller.people) {
			System.out.println(d.getName()+" "+  d.getLastName()+ " " + d.getBirthDate());
		}
		
		
		
	}

}
