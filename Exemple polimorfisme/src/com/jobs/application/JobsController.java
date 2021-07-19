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
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	/*public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee empleado = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(empleado);
	}*/

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager =  new Employee(name, address, phone, salaryPerMonth, PaymentFactory.createPaymentRateManager());
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

	public String getAllEmployees() {
		String member = "";
		List<Employee> empleados1 = new ArrayList<Employee>();	
		List<Volunteer> volunteer1 = new ArrayList<Volunteer>();
		for(int i=0; i<repository.getAllMembers().size();i++) {
			if(repository.getAllMembers().get(i).getName().contentEquals("Juan Volunteer")) {
				volunteer1.add((Volunteer) repository.getAllMembers().get(i));
			}else {
				empleados1.add((Employee) repository.getAllMembers().get(i));
			}}
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
				for(Volunteer volunteer: volunteer1) {
					member=  member + "\n" + "Vol "+ "[Name: " +
					volunteer.getName() + " Address: "+
					volunteer.getAddress()+" Phone: " + 
					volunteer.getPhone()+ " Description: " +
					volunteer.getDescription()+
					 " Total Paid: "+ 
					 volunteer.getTotalPaid()+ "]";		
			
		}
		
				return member ;
	}

	public void createVolunteer(String nombre, String direccion, String telefono) throws Exception {
		// TODO Auto-generated method stub
		try {
			Volunteer voluntario = new Volunteer(nombre, direccion, telefono);
			repository.addMember(voluntario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
