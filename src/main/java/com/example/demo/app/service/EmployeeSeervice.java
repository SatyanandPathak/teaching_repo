package com.example.demo.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.model.Employee;
import com.example.demo.app.repository.EmployeeRepository;

@Service
public class EmployeeSeervice {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> getEmployees(){
		return empRepo.findAll();
		
		
	}
	
	public Employee getEmployee(Integer id){
		return empRepo.findById(id).get();
	}
	
	public Employee createEmployee(Employee employee){
		return empRepo.save(employee);
	}
	
	public Employee updateEmployee(Employee employee, Integer id){
		
		Employee employeeToUpdate = empRepo.findById(id).get();
		
		// Need to handle exception if emp not found
		if (employeeToUpdate == null){
			return null;
		}
		
		employee.setId(id);
		return empRepo.save(employee);
		
	}
	
	
	public void deleteEmployee(Integer id){
		Employee employee = empRepo.findById(id).get();
		
		// Need to handle exceptions if employee is not found
		empRepo.delete(employee);
		
	}

}
