package com.jobs.domain;

public class Employee extends AbsStaffMember {

	
	

	protected  double salaryPerMonth;
	protected IPaymentRate paymentRate;	
	
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
		double salaryPerMonth = (super.salaryPerMonth)/1.1;
		public Junior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
				throws Exception {
			super(name, address, phone, salaryPerMonth, paymentRate);
			// TODO Auto-generated constructor stub
		}
		
	}
	public static class Mid extends Employee{
		double salaryPerMonth = (super.salaryPerMonth)/1.5;
		public Mid(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
				throws Exception {
			super(name, address, phone, salaryPerMonth, paymentRate);
			// TODO Auto-generated constructor stub
		}
		
	}
	public static class Senior extends Employee{
		double salaryPerMonth = (super.salaryPerMonth)/0.5;
		public Senior(String name, String address, String phone, double salaryPerMonth, IPaymentRate paymentRate)
				throws Exception {
			super(name, address, phone, salaryPerMonth, paymentRate);
			// TODO Auto-generated constructor stub
		}
		
	}
	
	
	@Override
	public void pay() throws Exception {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}
	

}
	
