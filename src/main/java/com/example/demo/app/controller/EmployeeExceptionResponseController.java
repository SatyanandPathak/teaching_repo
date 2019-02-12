package com.example.demo.app.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.app.exception.EmployeeBadRequestException;
import com.example.demo.app.exception.EmployeeNotFoundException;
import com.example.demo.app.exception.ExceptionResponse;
import com.example.demo.app.model.Employee;

@ControllerAdvice
@RestController
public class EmployeeExceptionResponseController extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(new Date(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNotFoundException(EmployeeNotFoundException ex, WebRequest req){
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
		// ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@ExceptionHandler(EmployeeBadRequestException.class)
	public ResponseEntity<ExceptionResponse> handleBadRequestException(EmployeeBadRequestException exception, WebRequest req){
		
		ExceptionResponse respose = new ExceptionResponse(new Date(), exception.getMessage(), req.getDescription(true));
		return new ResponseEntity<ExceptionResponse>(respose, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse respose = new ExceptionResponse(new Date(), "Validation failed", ex.getBindingResult().toString());
		return new ResponseEntity(respose, HttpStatus.BAD_REQUEST);
	}
	

}
