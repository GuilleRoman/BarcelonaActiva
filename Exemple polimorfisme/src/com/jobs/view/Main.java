package com.jobs.view;

import com.jobs.application.JobsController;

public class Main {

	
	
	private static JobsController controller=new JobsController();
	
	public static void main(String[] args) throws Exception {
		
		controller.createBossEmployee("Pepe Boss", "Direcci贸n molona", "666666666", 8001.0);
		controller.createMidEmployee("Pedro Employee", "Direcci贸n molona 2", "665266666", 2000.0);
		controller.createSeniorEmployee("Laura Employee", "Direcci贸n molona 3", "625266666", 3500.0);
		controller.createVolunteer("Juan Volunteer", "Direcci贸n molona 4", "614266666");
		controller.createManagerEmployee("Pedro Employee", "Direcci贸n molona 2", "665226666", 4500.0);
		controller.createJuniorEmployee("Marco Junior Employee","Direcci髇 molona 5", "655336420", 1200);
		
		controller.payAllEmployeers();
		
		String allEmployees=controller.getAllEmployees();
		
		System.out.println("EMPLOYEES: " + allEmployees + " \n");
		
	}

}
