package com.greatLearning.employeeREST.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleIllegalArgumentException(Exception exception) {
		System.out.println("Exception from the client side::" + exception.getMessage());
		return exception.getMessage();
	}
	
	@ExceptionHandler(Forbidden.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public String handleForbiddenException(Exception exception) {
		System.out.println("Exception Message is:: " + exception.getMessage());
		return exception.getMessage();
	}
	
}
