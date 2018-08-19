package com.sbc.projects.hibernatejpamysql.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @param This ExceptionHandler class will handle any exceptions including custom exceptions from any @Controller 
 * It uses CustomResponseMessage Object to respond to the exceptions
 * @return 
 * @ExceptionHandler(UserNotFoundException.class) will return status: NOT_FOUND, CustomResponseMessage Object as response
 * @ExceptionHandler(Exception.class) will return status: INTERNAL_SERVER_ERROR, CustomResponseMessage Object as response
 */


@ControllerAdvice		// ExceptionHandler handles any exceptions from all the Controllers
@RestController     // to send a Exception Response
public class CustomExceptionMessageHandler extends ResponseEntityExceptionHandler {

	
	// @Exception Handler(UserNotFoundException.class) will handle only UserNotFoundExceptions and will return 
	// custom message from 'CustomResponseMessage.java' Class with customized Status: NOT_FOUND
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(EmployeeNotFoundException ex, WebRequest request) {
		
		CustomExceptionMessage customExceptionMessage = new CustomExceptionMessage
				(ex.getMessage(), new Date(), request.getDescription(false));
		
		return new ResponseEntity(customExceptionMessage, HttpStatus.NOT_FOUND);
	}
	
	
	
	// @Exception Handler(UserNotCreatedException.class) will handle only UserNotFoundExceptions and will return 
	// custom message from 'CustomResponseMessage.java' Class with customized Status: NOT_FOUND
	
	@ExceptionHandler(UserNotCreatedException.class)
	public final ResponseEntity<Object> handleAllExceptions(UserNotCreatedException ex, WebRequest request) {
		
		CustomExceptionMessage customExceptionMessage = new CustomExceptionMessage
				(ex.getMessage(), new Date(), request.getDescription(false));
		
		return new ResponseEntity(customExceptionMessage, HttpStatus.BAD_REQUEST);
	
	}
	
	
}
