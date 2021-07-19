package com.jobs.application;

import com.jobs.domain.IPaymentRate;

public class PaymentFactory {

	
	public static IPaymentRate createPaymentRateBoss(){
		return new IPaymentRate() {	
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.5;
			}
		};
	}
	
	public static IPaymentRate createPaymentRateEmployee(){
		return new IPaymentRate() {
			
			@Override
			public double pay(double salaryPerMonth) {
				
				return salaryPerMonth; //to do 
			}
		};
	}
	public static IPaymentRate createPaymentRateJunior() {
		return new IPaymentRate() {
			
			@Override
			public double pay(double salaryPerMonth)throws Exception {
				if(salaryPerMonth < 900 || salaryPerMonth > 1600) throw new Exception();
					
				
				double cantidad = salaryPerMonth*0.15;
				return salaryPerMonth-cantidad; //to do 
			}
		};
	}
	public static IPaymentRate createPaymentRateMid(){
		return new IPaymentRate() {
			
			@Override
			public double pay(double salaryPerMonth) throws Exception{
				if(salaryPerMonth < 1800 || salaryPerMonth > 2500) throw new Exception();
				double cantidad = salaryPerMonth*0.10;
				return salaryPerMonth-cantidad; //to do 
			}
		};
	}
	public static IPaymentRate createPaymentRateSenior(){
		return new IPaymentRate() {
			
			@Override
			public double pay(double salaryPerMonth) throws Exception{
				if(salaryPerMonth < 2700 || salaryPerMonth > 4000) throw new Exception();
				double cantidad = salaryPerMonth*0.05;
				return salaryPerMonth-cantidad; //to do 
			}
		};
	}
	
	public static IPaymentRate createPaymentRateManager(){
		return new IPaymentRate() {
			@Override
			public double pay(double salaryPerMonth) {
				return salaryPerMonth*1.1; //to do 
			}
		};
	}
}
