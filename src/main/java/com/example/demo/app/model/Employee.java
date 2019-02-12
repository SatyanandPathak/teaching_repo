package com.example.demo.app.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
//@Table(name="EMPLOYEE_TABLE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	

	private Integer id;
	
	@Column(name="EMP_FIRST_NAME")
	
	@Size(min=2, message="First name should have minimum 2 characters")
	private String firstName;
	private String lastName;
	
	@DecimalMin(value="1000.00", message="Minimum Salary is 1000.00")
	@Digits(integer=8, fraction=2, message="Salary not in correct format")
	private BigDecimal salary;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(Integer id, String firstName, String lastName, BigDecimal salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	
}
