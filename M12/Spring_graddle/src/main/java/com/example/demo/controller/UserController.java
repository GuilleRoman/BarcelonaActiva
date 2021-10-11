package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.User;


@RestController
public class UserController {
		
		private static final String template= "Hello, %s!";
		@GetMapping("/")
		public User user(@RequestParam(value="message", defaultValue="World") String name) {
			return new User(String.format(template,name));
		}
		
	
		
		@GetMapping("/hello")
	    public String helloGradle() {
	        return "Hello World!";
	    }
		
		
	}

