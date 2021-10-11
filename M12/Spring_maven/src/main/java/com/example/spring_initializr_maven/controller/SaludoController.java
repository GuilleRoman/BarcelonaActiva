package com.example.spring_initializr_maven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_initializr_maven.salute.Saludo;



@RestController
public class SaludoController {
	private static final String template= "Hello, %s!";
	@GetMapping("/")
	public Saludo saludo(@RequestParam(value="message", defaultValue="World") String name) {
		return new Saludo(String.format(template,name));
	}
}