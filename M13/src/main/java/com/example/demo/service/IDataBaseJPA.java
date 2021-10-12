package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.bean.Employee;


public interface IDataBaseJPA {
	public void insert(Employee employee);
	public void delete(int id);
	public void modify(Employee employee);
	
	public ArrayList<Employee> getEmployees();
	public boolean checkUser(String user, String password);
	public Employee getEmployee(int id);
}
