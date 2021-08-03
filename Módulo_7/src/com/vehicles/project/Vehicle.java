package com.vehicles.project;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();
	protected Vehicle_Owner owner;
	public static ArrayList<Person> drivers= new ArrayList<Person>();
	
	
	
	public ArrayList<Person> getDrivers(){
		return drivers;
	}
	
	public String getPlate() {
		return plate;
	}
	public String getBrand() {
		return brand;
	}
	public String getColor() {
		return color;
	}
	public List<Wheel> getWheels() {
		return wheels;
	}
	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}
	public Vehicle() {
		
	}
}
