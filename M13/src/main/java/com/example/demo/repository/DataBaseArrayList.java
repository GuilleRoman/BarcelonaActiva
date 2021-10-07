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
		employees.add(new Employee(2, "Pepe", JobType.BUSSINESS));
		employees.add(new Employee(3, "Pepe", JobType.HR));
		employees.add(new Employee(4, "Pepe", JobType.INDUSTRIAL));
		employees.add(new Employee(5, "Pepe", JobType.MANAGER));
		employees.add(new Employee(6, "Pepe", JobType.QA));
		employees.add(new Employee(7, "Pepe", JobType.MAINTENANCE));
		employees.add(new Employee(8, "Pepe", JobType.DEVELOPER));
		employees.add(new Employee(9, "Pepe", JobType.DEVELOPER));
		employees.add(new Employee(10, "Pepe", JobType.BUSSINESS));
		employees.add(new Employee(11, "Pepe", JobType.IT));
		employees.add(new Employee(12, "Pepe", JobType.IT));
		employees.add(new Employee(13, "Pepe", JobType.MAINTENANCE));
		employees.add(new Employee(14, "Pepe", JobType.BUSSINESS));
		employees.add(new Employee(15, "Pepe", JobType.BUSSINESS));
		employees.add(new Employee(16, "Pepe", JobType.DEVELOPER));
		employees.add(new Employee(17, "Pepe", JobType.HR));
		employees.add(new Employee(18, "Pepe", JobType.QA));
		employees.add(new Employee(19, "Pepe", JobType.BUSSINESS));
		employees.add(new Employee(20, "Pepe", JobType.DEVELOPER));
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
	public void modify(Employee employee) {
		Iterator<Employee> it = employees.iterator();
		while(it.hasNext()) {
			Employee emp = it.next();
			if(emp.getId()== employee.getId()) {
				emp.setName(employee.getName());
				emp.setJob(employee.getJob());
				emp.setId(employee.getId());
				break;
			}
		}
	}
}
