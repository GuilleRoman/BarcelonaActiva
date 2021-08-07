package com.vehicles.project;

import javax.swing.JOptionPane;

public class Main {
	
	public static VehicleController controller = new VehicleController();
	public static People_Controller peopleController = new People_Controller();
	public static int counter=1;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean keepCreating= true;
		while(keepCreating) {
			People_Controller.createVehicleOwner();
			String choiceToCreate= JOptionPane.showInputDialog(null, "¿Which vehicle would you like to create? (Car/Bike/Truck)");	
				if(choiceToCreate.matches("Car")) {
					controller.createCar();
					controller.createWheelsForCar();
			}	else if (choiceToCreate.matches("Bike")) {
					controller.createBike();
					controller.createWheelsForBike();
			}  	else if (choiceToCreate.matches("Truck")) {
					controller.createTruck();
					controller.createWheelsForCar();
			} 	
				
			peopleController.ownerIsDriver();
			
			for(Vehicle e:VehicleController.vehicles) {
				System.out.println("Vehículo: "+e.getBrand()+" "+ e.getColor()+" " +e.plate+" \nDueño del vehículo: " +e.owner.getName()+" "+e.owner.getLastName());
			}
				
				System.out.println("-------------------------\nConductores: \n-------------------------");
			try {
				
			
				for(int i=0; i<Vehicle.drivers.size();i++) {
					if(Vehicle.drivers.get(i+1).getName()==Vehicle.drivers.get(i).getName()) {
						continue;
					}else {
						System.out.println(Vehicle.drivers.get(i).getName()+" "+  Vehicle.drivers.get(i).getLastName()+ " " + Vehicle.drivers.get(i).getBirthDate());
					}
				}
			}	catch (java.lang.IndexOutOfBoundsException e) {
					System.out.println("Hay un error en la lectura del array");
				}
			Vehicle.drivers.clear();
			VehicleController.backWheels.clear();
			VehicleController.frontWheels.clear();
			VehicleController.vehicles.clear();
			String ask = JOptionPane.showInputDialog(null, "¿Would you like to add new owners and vehicles? (Yes/No)");
				if(!ask.equalsIgnoreCase("Yes")) {
					break;
			 }
		}
	}
	
}
