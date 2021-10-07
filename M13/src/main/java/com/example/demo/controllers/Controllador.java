package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.bean.Employee;
import com.example.demo.bean.User;
import com.example.demo.repository.DataBaseArrayList;

@Controller
@RequestMapping("")
public class Controllador {
	
	DataBaseArrayList database1= new DataBaseArrayList();
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
		// código del método empaquetado en clase
		  ArrayList<Employee> employees = database1.getEmployees();
		 if (user.getName().equals("admin") && user.getPassword().equals("admin"))
			 model.addAttribute("user", user);
			 this.user=user;
			 model.addAttribute("employees", employees);
			
			 
			 return "consulta";	
	}
	
	@PostMapping("/insert")
	public String insert(Employee employee, Model model) {
		database1.insert(employee);
		ArrayList<Employee> employees = database1.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Insert Employee");
		model.addAttribute("action", "/insert");
		model.addAttribute("employee", null);
		
		return "consulta";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		database1.delete(id);
		ArrayList<Employee> employees = database1.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Insert Employee");
		model.addAttribute("action", "/insert");
		return "consulta";
	}
	
	@GetMapping("/modify/{id}")
	public String modify(@PathVariable int id, Model model) {
		Employee employee= database1.getEmployee(id);
		ArrayList<Employee> employees = database1.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", employee);
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Modify Employee");
		model.addAttribute("action", "/modify");
		return "consulta";
	}
	@PostMapping("/modify")
	public String modify2(Employee employee, Model model) {
		database1.modify(employee);
		ArrayList<Employee> employees = database1.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", null);
		model.addAttribute("user", this.user);
		model.addAttribute("button", "Insert Employee");
		model.addAttribute("action", "/insert");
		return "consulta";
	}
	
	
	
}
