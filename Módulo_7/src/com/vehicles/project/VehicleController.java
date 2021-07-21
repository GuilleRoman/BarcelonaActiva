package com.vehicles.project;

import java.util.ArrayList;

public class VehicleController {
 
 public static ArrayList<Wheel> frontWheels = new ArrayList<Wheel>();
 public static ArrayList<Wheel> backWheels = new ArrayList<Wheel>();
 public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
 
 		public void createCar() {
 			Car car = new Car();
 			vehicles.add(car);
 		}
 		public void createFrontWheels() {
 			Wheel frontWheel = new Wheel();
 			Wheel frontWheel2 = new Wheel();
 			frontWheels.add(frontWheel);
 			frontWheels.add(frontWheel2);
 			
 		}
 		public void createBackWheels() {
 			Wheel backWheel = new Wheel();
 			Wheel backWheel2 = new Wheel();
 			backWheels.add(backWheel);
 			backWheels.add(backWheel2);
 		}
 		public void createWheels() throws Exception {
 			createFrontWheels();
 			createBackWheels();
 			Car.addWheels(frontWheels, backWheels);
 		}
}
