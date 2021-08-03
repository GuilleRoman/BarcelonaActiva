package com.vehicles.project;

import javax.swing.JOptionPane;

public class Main {
	
	public static VehicleController controller = new VehicleController();
	public static People_Controller peopleController = new People_Controller();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean keepCreating= true;
		while(keepCreating) {
			// peopleController.creationSecuence();
			People_Controller.createVehicleOwner();
			String choiceToCreate= JOptionPane.showInputDialog(null, "¿Which vehicle would you like to create? (Car/Bike/Truck)");	
				if(choiceToCreate.matches("Car")) {
					controller.createCar();
					controller.createWheelsForCar();
			}	 else if (choiceToCreate.matches("Bike")) {
					controller.createBike();
					controller.createWheelsForBike();
			}  	else if (choiceToCreate.matches("Truck")) {
					controller.createTruck();
					controller.createWheelsForCar();
			} 	
				
				for(Vehicle e:VehicleController.vehicles) {
					System.out.println(e.getBrand()+" "+ e.getColor()+" " +e.plate);
			}
			
				for(Person d: Vehicle.drivers) {
					System.out.println(d.getName()+" "+  d.getLastName()+ " " + d.getBirthDate());
			}
				String ask = JOptionPane.showInputDialog(null, "¿Would you like to add new owners and vehicles? (Yes/No)");
					if(!ask.equalsIgnoreCase("Yes")) {
						break;
			 }
		}
		
	}

}
