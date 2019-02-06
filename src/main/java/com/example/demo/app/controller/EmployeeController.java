package com.example.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.app.model.Employee;
import com.example.demo.app.service.EmployeeSeervice;

@RestController
@RequestMapping("employees")
public class EmployeeController {
	
	@Autowired
	EmployeeSeervice empService;
	
	@GetMapping
	public List<Employee> getEmployees(){
		return empService.getEmployees();
	}
	
	@GetMapping(value="{id}")
	public Employee getEmployee(@PathVariable("id") Integer id){
		return empService.getEmployee(id);
	}
	
	
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee){
		return empService.createEmployee(employee);
	}
	
	@PutMapping(value="{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Integer id){
		return empService.updateEmployee(employee, id);
	}
	
	@DeleteMapping(value="{id}")
	public void deleteEmployee(@PathVariable Integer id){
		empService.deleteEmployee(id);
	}
	
	
	

}
