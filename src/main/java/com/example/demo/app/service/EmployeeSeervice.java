package com.example.demo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.model.Employee;
import com.example.demo.app.repository.EmployeeRepository;

// eligibility criteria # 2 for bean creation
// @RestController, @Service, @Repository, @Component, @Entity are the possible options
@Service
public class EmployeeSeervice {
	
	
	// Here EmployeeRepo is an interface. So we cannot create its object.
	// What spring is doing for us is, it is creating an object of a class which implements EmployeeRepository
	// Interface
	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> getEmployees(){
		
		// select * from employee
		return empRepo.findAll();
	}
	
	public Employee getEmployee(Integer id){
		// Select * from employee where emp_id = {id}
		
		Optional<Employee> empOptional = empRepo.findById(id);
		
		if(empOptional.isPresent()){
			return empRepo.findById(id).get();
		} 
		
		return null;
		
		
	}
	
	public Employee createEmployee(Employee employee){
		
		// insert into employee values()
		return empRepo.save(employee);
	}
	
	public Employee updateEmployee(Employee employee, Integer id){
		
		// Update employee
		Employee employeeToUpdate = empRepo.findById(id).get();
		
		// Need to handle exception if emp not found
		if (employeeToUpdate == null){
			return null;
		}
		
		employee.setId(id);
		return empRepo.save(employee);
		
	}
	
	
	public void deleteEmployee(Integer id){
		// Delete employees
		Employee employee = empRepo.findById(id).get();
		
		// Need to handle exceptions if employee is not found
		empRepo.delete(employee);
		
	}

}
