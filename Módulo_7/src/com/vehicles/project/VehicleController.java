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
 			Wheel wheel = new Wheel();
 			Wheel wheel2 = new Wheel();
 			frontWheels.add(wheel);
 			frontWheels.add(wheel2);
 			
 		}
 		public void createBackWheels() {
 			Wheel wheel = new Wheel();
 			Wheel wheel2 = new Wheel();
 			backWheels.add(wheel);
 			backWheels.add(wheel2);
 		}
}
