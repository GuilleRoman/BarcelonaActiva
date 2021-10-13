package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Employee;
import com.example.demo.bean.JobType;
import com.example.demo.repository.DataBaseJPA;

@Service
public class DataBaseJPAService implements IDataBaseJPA {
	private Connection connection;
	@Autowired
	DataBaseJPA database3;
	@Override
	public void insert(Employee employee) {
		// TODO Auto-generated method stub
		Employee newEmployee = new Employee(employee.getId(), employee.getName(), employee.getJob());
		database3.save(newEmployee);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		database3.deleteById(id);
	}

	@Override
	public void modify(Employee employee) {
		// TODO Auto-generated method stub
		Employee newEmployee = new Employee(employee.getId(), employee.getName(), employee.getJob());
		database3.save(newEmployee);
	}

	
	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee= database3.findById(id);
		return employee.get();
	}

	@Override
	public ArrayList<Employee> getEmployees() {
		// TODO Auto-generated method stub
		ArrayList<Employee> employees = (ArrayList<Employee>) database3.findAll();
		return employees;
	}

	@Override
	public boolean checkUser(String user, String password) {
		// TODO Auto-generated method stub
		
		boolean check= false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connect= "jdbc:mysql://localhost:3306/employees_repository";
			this.connection= DriverManager.getConnection(connect,"root","");
			Statement s;
			s = connection.createStatement();
			String query="SELECT COUNT(*) FROM EMPLOYEES WHERE user='"+ user +"'"+ "AND password='"+password+"'";
			s.execute(query);
			ResultSet results = s.getResultSet();
			results.next();
			if(results.getInt(1)>0) {
				check=true;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return check;
		
	}

	
	
}
