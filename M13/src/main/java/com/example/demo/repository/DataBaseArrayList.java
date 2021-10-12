package com.example.demo.repository;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.bean.Employee;
import com.example.demo.bean.JobType;

public class DataBaseArrayList {
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public DataBaseArrayList() {
		employees.add(new Employee(1, "Pepe", JobType.DEVELOPER));
		employees.add(new Employee(2, "Juan", JobType.BUSSINESS));
		employees.add(new Employee(3, "María", JobType.HR));
		employees.add(new Employee(4, "Marta", JobType.INDUSTRIAL));
		employees.add(new Employee(5, "Cristina", JobType.MANAGER));
		employees.add(new Employee(6, "Jorge", JobType.QA));
		employees.add(new Employee(7, "Laia", JobType.MAINTENANCE));
		employees.add(new Employee(8, "Kevin", JobType.DEVELOPER));
		employees.add(new Employee(9, "Francisco", JobType.DEVELOPER));
		employees.add(new Employee(10, "Jose María", JobType.BUSSINESS));
		employees.add(new Employee(11, "Andreu", JobType.IT));
		employees.add(new Employee(12, "Berto", JobType.IT));
		employees.add(new Employee(13, "Alma", JobType.MAINTENANCE));
		employees.add(new Employee(14, "Natalia", JobType.BUSSINESS));
		employees.add(new Employee(15, "Almudena", JobType.BUSSINESS));
		employees.add(new Employee(16, "Carlos", JobType.DEVELOPER));
		employees.add(new Employee(17, "Cristian", JobType.HR));
		employees.add(new Employee(18, "Mike", JobType.QA));
		employees.add(new Employee(19, "Ashley", JobType.BUSSINESS));
		employees.add(new Employee(20, "Javier", JobType.DEVELOPER));
	}
	
	public ArrayList<Employee> getEmployees(){
		return employees;
	}
	
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees=employees;
	}
	public Employee getEmployee(@PathVariable int id) {	
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
			Employee emp = it.next();
			if(emp.getId()==id) {
				return emp;
			}
		}
		return null;	
	}
	
//	public Employee getEmployee(@PathVariable JobType job) {	
//		Iterator<Employee> it = employees.iterator();
//		while(it.hasNext()) {
//			Employee emp = it.next();
//			if(emp.getJob()==job) {
//				return emp;
//			}
//		}
//		return null;	
//	}
	
	public ArrayList<Employee> searchByJob(@PathVariable JobType job){
		ArrayList<Employee> employeesFound = new ArrayList<Employee>();
		for(Employee e: this.employees) {
			if(e.getJob().equals(job)) employeesFound.add(e);
		}
		return employeesFound;
	}
	
	public void insert(Employee employee) {
		this.employees.add(employee);
	}
	public void delete(int id) {
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
			Employee emp = it.next();
			if(emp.getId()==id) {
				it.remove();
			}
		}
	}
	
	public void delete(@PathVariable JobType job) {
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
			Employee emp = it.next();
			if(emp.getJob()==job) {
				continue;
			}else {
				it.remove();
			}
		}
	}
	
	
	
	
	
	public void modify(Employee employee) {
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
			Employee emp = it.next();
			if(emp.getId()== employee.getId()) {
				emp.setName(employee.getName());
				emp.setJob(employee.getJob());
				emp.setId(employee.getId());
				emp.setSalary(employee.getSalary());
				break;
			}
		}
	}
}
