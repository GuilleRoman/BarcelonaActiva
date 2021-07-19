package com.jobs.domain;

public class Employee extends AbsStaffMember {

	
	

	protected  double salaryPerMonth;
	protected  double salaryNetoPerMonth;
	protected  double salaryBrutoAnual;
	protected  double salaryNetoAnual;
	protected IPaymentRate paymentRate;
	



	public double getSalaryNetoPerMonth() {
		return salaryNetoPerMonth;
	}


	public void setSalaryNetoPerMonth(double salaryNetoPerMonth) {
		this.salaryNetoPerMonth = salaryNetoPerMonth;
	}


	public double getSalaryBrutoAnual() {
		return salaryBrutoAnual;
	}


	public void setSalaryBrutoAnual(double salaryBrutoAnual) {
		this.salaryBrutoAnual = salaryBrutoAnual;
	}


	public double getSalaryNetoAnual() {
		return salaryNetoAnual;
	}


	public void setSalaryNetoAnual(double salaryNetoAnual) {
		this.salaryNetoAnual = salaryNetoAnual;
	}


	
	
	public  double getSalaryPerMonth() {
		return salaryPerMonth;
	}


	public void setSalaryPerMonth(double salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}


	public IPaymentRate getPaymentRate() {
		return paymentRate;
	}


	public void setPaymentRate(IPaymentRate paymentRate) {
		this.paymentRate = paymentRate;
	}
	
	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	public static class Junior extends Employee {
		
		public Junior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
				throws Exception {
			super(name, address, phone, salaryPerMonth, paymentRate);
			// TODO Auto-generated constructor stub
			
			this.salaryNetoPerMonth = salaryPerMonth-(2/salaryPerMonth*100);
			this.salaryBrutoAnual= salaryPerMonth*12;
			this.salaryNetoAnual=salaryNetoPerMonth*12; 
		}
		
	}
	public static class Mid extends Employee{
		
		public Mid(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
				throws Exception {
			super(name, address, phone, salaryPerMonth, paymentRate);
			this.salaryNetoPerMonth = salaryPerMonth-(15/salaryPerMonth*100);
			this.salaryBrutoAnual= salaryPerMonth*12;
			this.salaryNetoAnual=salaryNetoPerMonth*12;
			
			// TODO Auto-generated constructor stub
		}
		
	}
	public static class Senior extends Employee{
		
		public Senior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
				throws Exception {
			super(name, address, phone, salaryPerMonth, paymentRate);
			// TODO Auto-generated constructor stub
			this.salaryNetoPerMonth = salaryPerMonth-(24/salaryPerMonth*100);
			this.salaryBrutoAnual= salaryPerMonth*12;
			this.salaryNetoAnual=salaryNetoPerMonth*12;
		}
		
	}
	
	
	@Override
	public void pay() throws Exception {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}
	

}
	
