package springBootInitialDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springBootInitialDemo.dto.User;
import springBootInitialDemo.service.IUserService;

@RestController
@RequestMapping("")
public class SecondController {
	private final IUserService userService;
	private static final String template= "Hello, %s!";
	@GetMapping("/")
	public User user(@RequestParam(value="message", defaultValue="World") String name) {
		return new User(String.format(template,name));
	}
	
	@Autowired
    public SecondController(IUserService userService){
        this.userService = userService;
    }
	
	@GetMapping("/hello")
    public String helloGradle() {
        return "Hello World!";
    }
	
	
}
