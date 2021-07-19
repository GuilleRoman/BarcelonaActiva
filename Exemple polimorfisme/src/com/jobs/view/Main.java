package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Dirección molona", "666666666", 8001.0);
		controller.createMidEmployee("Pedro Employee", "Dirección molona 2", "665266666", 2000.0);
		controller.createSeniorEmployee("Laura Employee", "Dirección molona 3", "625266666", 3500.0);
		controller.createVolunteer("Juan Volunteer", "Dirección molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Dirección molona 2", "665226666", 4500.0);
		controller.createJuniorEmployee("Marco Junior Employee","Direcci�n molona 5", "655336420", 1200);
		
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
		
	}

}
