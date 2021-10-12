package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.bean.Employee;
import com.example.demo.bean.JobType;

public class DataBaseJDBC {
	private Connection connection;
	
	public DataBaseJDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connect= "jdbc:mysql://localhost:3306/employees_repository";
			this.connection= DriverManager.getConnection(connect,"root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insert(Employee employee) {
		String query ="INSERT INTO EMPLOYEES (id, name, job, salary)"+ "VALUES (?, ?, ?, ?)";
		
		PreparedStatement preparedQuery;
		try {
			preparedQuery= connection.prepareStatement(query);
			preparedQuery.setInt(1, employee.getId());
			preparedQuery.setString(2, employee.getName());
			preparedQuery.setString(3, employee.getJob().toString());
			preparedQuery.setDouble(4, employee.getSalary());
			preparedQuery.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void delete(int id) {
		String query= "DELETE FROM EMPLOYEES WHERE id="+id;
		try {
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Employee> getEmployees(){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT * FROM EMPLOYEES";
			s.execute(query);
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Employee employee= new Employee(results.getInt(1), results.getString(2),
						JobType.valueOf(results.getString(3)));
				employees.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
		
	}
	
	public Employee getEmployee(int id) {
		Employee employee = null;
		
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT * FROM EMPLOYEES WHERE ID="+ id;
			s.execute(query);
			ResultSet results = s.getResultSet();
			results.next();
			employee = new Employee(results.getInt(1), results.getString(2),
					JobType.valueOf(results.getString(3)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
		
	}
	
	public ArrayList<Employee> searchByJob(@PathVariable JobType job) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT * FROM EMPLOYEES WHERE job="+"\'"+job+"\'";
			s.execute(query);
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Employee employee= new Employee(results.getInt(1), results.getString(2),
						JobType.valueOf(results.getString(3)));
						employees.add(employee);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
		
	}
	
	public void modify(Employee employee) {
		String query ="UPDATE EMPLOYEES SET name=?, job=?, salary=?"+ " WHERE id=?";
		
		PreparedStatement preparedQuery;
		try {
			preparedQuery= connection.prepareStatement(query);
			
			preparedQuery.setString(1, employee.getName());
			preparedQuery.setString(2, employee.getJob().toString());
			preparedQuery.setDouble(3, employee.getSalary());
			preparedQuery.setInt(4, employee.getId());
			System.out.println(preparedQuery);
			preparedQuery.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkUser(String user, String password) {
		boolean check= false;
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT COUNT(*) FROM EMPLOYEES WHERE user='"+ user +"'"+ "AND password='"+password+"'";
			s.execute(query);
			ResultSet results = s.getResultSet();
			results.next();
			if(results.getInt(1)>0) {
				check=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return check;
		
	}
}

//INSERT INTO `employees`(`id`, `name`, `job`, `salary`) VALUES (1, "Pepe", "DEVELOPER", 75000), (2, "Juan", "BUSSINESS", 60000), (3, "María", "HR", 45000), (4, "Marta", "INDUSTRIAL", 65000), (5, "Cristina", "MANAGER", 85000), (6, "Jorge", "QA", 55000), (7, "Laia", "MAINTENANCE", 30000), (8, "Kevin", "DEVELOPER", 75000), (9, "Francisco", "DEVELOPER", 75000), (10, "Jose María","BUSSINESS", 60000), (11, "Andreu", "IT", 60000), (12, "Berto", "IT", 60000), (13, "Alma", "MAINTENANCE", 30000), (14, "Natalia", "BUSSINESS", 60000), (15, "Almudena", "BUSSINESS", 60000), (16, "Carlos", "DEVELOPER", 75000), (17, "Cristian", "HR", 45000), (18, "Mike", "QA", 55000), (19, "Ashley", "BUSSINESS", 60000), (20, "Javier", "DEVELOPER", 75000)