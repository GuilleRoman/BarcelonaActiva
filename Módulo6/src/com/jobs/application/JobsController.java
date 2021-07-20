package com.jobs.application;


import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Employee.*;

import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController() {
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Boss boss = new Boss(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	/* We don't need this method anymore since there are specific subclasses of Employees.
	 * 
	 * public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee empleado = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(empleado);
		
	}*/
	// METHODS FOR CREATING CLASSES --
	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Manager manager =  new Manager(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
		repository.addMember(manager);
		
	}
	public void createJuniorEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Junior junior = new  Junior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateJunior());
		repository.addMember(junior);
		
	}
	public void createMidEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Mid mid = new  Mid(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateMid());
		repository.addMember(mid);
		
	}
	public void createSeniorEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Senior senior = new  Senior(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateSenior());
		repository.addMember(senior);
		
	}


		
	public void payAllEmployeers() throws Exception {
		for (AbsStaffMember element : repository.getAllMembers()) {
			element.pay();
		
			
		}
	
	}
	//this method implements the payBonus() from Employee class, to pay the bonus to all employeers.
	public void payBonusAllEmployeers() throws Exception {
		for (AbsStaffMember element : repository.getAllMembers()) {
			element.payBonus();
			
		
			
		}
	
	}
	
			//METHOD FOR PRINTING ALL DIFFERENT EMPLOYEES
			// IT EXTRACTS THE ARRAYLIST REPOSITORY INTO DIFFERENT CLASSES'S ARRAYLISTS
			// IN ORDER TO BE ABLE TO ACCESS TO THEIR METHODS.
			// THEN IT PRINTS THE VALUE OF EACH INDEX INTO THE STRING MEMBER.
	public String getAllEmployees() {
		String member = "";
		List<Employee> empleados1 = new ArrayList<Employee>();	
		List<Volunteer> volunteer1 = new ArrayList<Volunteer>();
		
		// Separate each type of AbsStaffMember into different Lists.
		for(int i=0; i<repository.getAllMembers().size();i++) {
			if(repository.getAllMembers().get(i).getName().contentEquals("Juan Volunteer")) {
				volunteer1.add((Volunteer) repository.getAllMembers().get(i));
			}else {
				empleados1.add((Employee) repository.getAllMembers().get(i));
			}}
			//Print each employee into the String member.
				for(Employee empleado: empleados1) {
					member=  member + "\n" + "Emp "+"[Name: " +
					empleado.getName() + " Address: "+
					empleado.getAddress()+" Phone: " + 
					empleado.getPhone()+ " Monthly Gross Salary: " +
					empleado.getSalaryPerMonth()+" Total Paid: "+ 
					empleado.getTotalPaid()+" Monthly Net Salary: "+
					empleado.getSalaryNetoPerMonth()+" Annual Gross Salary: "+
					empleado.getSalaryBrutoAnual() +" Annual Net Salary: " +
					empleado.getSalaryNetoAnual()+"]";
		}
				////Print each volunteer into the String member.
				for(Volunteer volunteer: volunteer1) {
					member=  member + "\n" + "Vol "+ "[Name: " +
					volunteer.getName() + " Address: "+
					volunteer.getAddress()+" Phone: " + 
					volunteer.getPhone()+ " Description: " +
					volunteer.getDescription()+
					 " Ayuda recibida: "+ 
					 volunteer.getTotalPaid()+ "]";		
			
		}
		
				return member ;
	}

	public void createVolunteer(String nombre, String direccion, String telefono, boolean ayuda) throws Exception {
		// TODO Auto-generated method stub
		try {
			Volunteer voluntario = new Volunteer(nombre, direccion, telefono, ayuda);
			repository.addMember(voluntario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
