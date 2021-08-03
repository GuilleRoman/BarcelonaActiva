package com.vehicles.project;

import java.util.ArrayList;

public class People_Controller {
	public static ArrayList<Person> people = new ArrayList<Person>();
	public void createVehicleOwner() {
		Vehicle_Owner owner = new Vehicle_Owner();
		people.add(owner);
	}
	public void createDriver() throws Exception {
		Driver driver = new Driver("Guillermo", "Román Medrano", "21/08/1994");
		people.add(driver);
	}
	public void createDriver(String name, String lastName, String birthDate) throws Exception {
		Driver driver = new Driver(name, lastName, birthDate);
	}
}
