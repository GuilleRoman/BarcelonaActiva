package com.vehicles.project;

import java.util.ArrayList;

public class VehicleController {
 
 public static ArrayList<Wheel> frontWheels = new ArrayList<Wheel>();
 public static ArrayList<Wheel> backWheels = new ArrayList<Wheel>();
 public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
 
 		public void createCar() throws Exception {
 			Car car = new Car();
 			vehicles.add(car);
 		}
 		public void createBike() throws Exception {
 			Bike bike = new Bike();
 			vehicles.add(bike);
 		}
 		public void createFrontWheels() throws Exception {
 			Wheel frontWheel = new Wheel();
 			Wheel frontWheel2 = frontWheel;
 			frontWheels.add(frontWheel);
 			frontWheels.add(frontWheel2);
 			
 		}
 		public void createBackWheels() throws Exception {
 			Wheel backWheel = new Wheel();
 			Wheel backWheel2 = backWheel;
 			backWheels.add(backWheel);
 			backWheels.add(backWheel2);
 		}
 		public void createWheelsForCar() throws Exception {
 			createFrontWheels();
 			createBackWheels();
 			Car.addWheels(frontWheels, backWheels);
 		}
 		public void createWheelsForBike() throws Exception {
 			createFrontWheels();
 			
 			Bike.addWheels(frontWheels);
 		}
}
