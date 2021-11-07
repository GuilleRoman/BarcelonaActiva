package com.botiga.exceptions;


import java.util.NoSuchElementException;


import org.springframework.expression.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class ExceptionHandlerController extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(NoSuchElementException.class)
	ResponseEntity<String> handleEmptyInput(NoSuchElementException e){
		return new ResponseEntity<String>("Element not found", HttpStatus.NO_CONTENT)	;
	}
	
	@ExceptionHandler(NullPointerException.class)
	ResponseEntity<String> handleEmptyInput(NullPointerException e){
		return new ResponseEntity<String>(" Element's value was expected and is null, maybe your variable wasnt initialized", HttpStatus.NOT_FOUND)	;
	}
	
	@ExceptionHandler(InternalServerError.class)
	ResponseEntity<String> handleEmptyInput(InternalServerError e){
		return new ResponseEntity<String>(" Theres a problem with your server internal request", HttpStatus.BAD_GATEWAY)	;
	}
	
	//Code for global exception handling
//	@ExceptionHandler(Exception.class)
//	ResponseEntity<String> handleEmptyInput(Exception e){
//		return new ResponseEntity<String>("Element could not be found, try to debug your code to look deeply", HttpStatus.valueOf(getLocalizedMessage()))	;
//	}
	
	@ExceptionHandler(NumberFormatException.class)
	ResponseEntity<String> handleEmptyInput(NumberFormatException e){
		return new ResponseEntity<String>(" Introduce a valid number corresponding an ID, not text", HttpStatus.BAD_REQUEST)	;
	}
	
	@ExceptionHandler(ClassNotFoundException.class)
	ResponseEntity<String> handleEmptyInput(ClassNotFoundException e){
		return new ResponseEntity<String>(" Couldn't find the class in the path specified, try to look for a reference to that or build a correct path", HttpStatus.NOT_FOUND)	;
	}
	
	@ExceptionHandler(NoSuchMethodException.class)
	ResponseEntity<String> handleEmptyInput(NoSuchMethodException e){
		return new ResponseEntity<String>(" Couldn't find the class in the path specified, try to look for a reference to that or build a correct path", HttpStatus.METHOD_NOT_ALLOWED)	;
	}
	
	@ExceptionHandler(ClassCastException.class)
	ResponseEntity<String> handleEmptyInput(ClassCastException e){
		return new ResponseEntity<String>(" Couldn't find the class in the path specified, try to look for a reference to that or build a correct path", HttpStatus.CONFLICT)	;
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	ResponseEntity<String> handleEmptyInput(MethodArgumentTypeMismatchException e){
		return new ResponseEntity<String>(" Couldn't find the class in the path specified, try to look for a reference to that or build a correct path", HttpStatus.BAD_REQUEST)	;
	}

	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	ResponseEntity<String> handleEmptyInput(HttpRequestMethodNotSupportedException e){
		return new ResponseEntity<String>(" Take a look at the method for the HTTP request, this wasnt properly formulated", HttpStatus.METHOD_NOT_ALLOWED)	;
	}
	
	@ExceptionHandler(ParseException.class)
	ResponseEntity<String> handleEmptyInput(ParseException e){
		return new ResponseEntity<String>(" There's a problem with your template, take a look at the model", HttpStatus.INTERNAL_SERVER_ERROR)	;
	}
	
	
}
