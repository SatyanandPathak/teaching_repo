package com.example.demo.app.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.app.exception.EmployeeNotFoundException;
import com.example.demo.app.model.Employee;
import com.example.demo.app.service.EmployeeSeervice;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeSeervice empService;

	// http://localhost:8080/employees
	@GetMapping
	public List<Employee> getEmployees() {
		return empService.getEmployees();
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id) {

		Employee employee = empService.getEmployee(id);

		if (employee == null) {
			throw new EmployeeNotFoundException("Employee Not Found");
		} else {
//			Resource<Employee> resource = new Resource<Employee>(employee);
//			ControllerLinkBuilder.linkTo(controller)

			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}

	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		Employee newEmployee = empService.createEmployee(employee);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(newEmployee.getId())
		.toUri();
		
		//new ResponseEntity(newEmployee, HttpStatus.CREATED);
		//ResponseEntity.created().body(newEmployee);
		
		return ResponseEntity
				.created(null)
				.body(newEmployee);
	}

	@PutMapping(value = "{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer id) {
				
		return empService.updateEmployee(employee, id);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity deleteEmployee(@PathVariable Integer id) {

		// First we deleted the employee
		empService.deleteEmployee(id);

		// Returned proper code i.e, 204
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

}
