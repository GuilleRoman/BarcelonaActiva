package com.example.demo.controllers;

import java.util.ArrayList;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Employee;
import com.example.demo.bean.JobType;
import com.example.demo.bean.User;
import com.example.demo.repository.DataBaseArrayList;
import com.example.demo.repository.DataBaseJDBC;
import com.example.demo.repository.DataBaseJPA;
import com.example.demo.service.DataBaseJPAService;

@Controller
@RequestMapping("")
public class Controllador {
	
//	DataBaseArrayList db= new DataBaseArrayList();

	DataBaseJDBC db= new DataBaseJDBC();
	//@Autowired
	//DataBaseJPAService db;
	Employee employee;
	User user;
	
	
	@GetMapping("/")
	public String start(Model model) {
		model.addAttribute("titulo", "LOGIN FORM");
		return "login";
	}
	
	/*Este método permite hacer el login en el formulario para acceder a los datos que presentemos
	 Comprueba que el usuario y contraseña introducidos son correctos
	 Para el método de uno a uno comprueba los parametros de @RequestParam
	 Para el método empaquetado he definido la clase usuario con name y password, que comprueba.*/
	@PostMapping("/")
	public String login(User user, Model model) {
		ArrayList<Employee> employees = db.getEmployees();
		
		 if (user.getName().equals("admin") && user.getPassword().equals("admin"))
			 
			 this.user=user;
			 model.addAttribute("user", user);
			
			 model.addAttribute("employees", employees);
			 model.addAttribute("employee", new Employee());
			 model.addAttribute("button", "Insert Employee");
			 model.addAttribute("action", "/insert");
			 return "consulta";	
	}
	
	@PostMapping("/insert")
	public String insert(Employee employee, Model model) {
		db.insert(employee);
		ArrayList<Employee> employees = db.getEmployees();
		
		model.addAttribute("employees", employees);
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Insert Employee");
		model.addAttribute("action", "/insert");
		model.addAttribute("employee", new Employee());
		
		
		return "consulta";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {

		db.delete(id);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Insert Employee");
		model.addAttribute("action", "/insert");
		return "consulta";
	}
	
	@GetMapping("/modify/{id}")
	public String modify(@PathVariable int id, Model model) {
		
		Employee employee = db.getEmployee(id);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", employee);
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Modify Employee");
		model.addAttribute("action", "/modify");
		return "consulta";
	}
	@PostMapping("/modify")
	public String modify2(Employee employee, Model model) {

		db.modify(employee);
		ArrayList<Employee> employees = db.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Insert Employee");
		model.addAttribute("action", "/insert");
		return "consulta";
	}
	
	//Búsqueda por trabajo por BD arraylist y JDBC
	@GetMapping("/search/{job}")
	public String search(@PathVariable JobType job, Model model) {

		ArrayList<Employee> employees = db.searchByJob(job);
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Insert Employee");
		model.addAttribute("action", "/insert");
		return "consulta";
	}
	
	@PostMapping("/search")
	public String search1(@PathVariable JobType job,Employee employee, Model model) {

		ArrayList<Employee> employees = db.searchByJob(job);
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("user", this.user);
		//model.addAttribute("Jobtypes", JobType.values());
		model.addAttribute("button", "Insert Employee");
	model.addAttribute("action", "/insert");
		return "consulta";
	}
	
	// Búsqueda por ID por BD JPA
//	@PostMapping("/search")
//	public String search1(@PathVariable int id,Employee employee, Model model) {
//
//		Employee employees = db.getEmployee(id);
//		model.addAttribute("employees", employees);
//		model.addAttribute("employee", new Employee());
//		model.addAttribute("user", this.user);
//		//model.addAttribute("Jobtypes", JobType.values());
//		model.addAttribute("button", "Insert Employee");
//		model.addAttribute("action", "/insert");
//		return "consulta";
//	}
//	
//	
//	@GetMapping("/search/{id}")
//	public String search(@PathVariable int id, Model model) {
//
//		Employee employees = db.getEmployee(id);
//		model.addAttribute("employees", employees);
//		model.addAttribute("employee", new Employee());
//		model.addAttribute("user", this.user);
//		model.addAttribute("button", "Insert Employee");
//		model.addAttribute("action", "/insert");
//		return "consulta";
//	}
	
	
	
}
