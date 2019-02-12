package com.example.demo.app.bootstrap;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.app.model.Employee;
import com.example.demo.app.repository.EmployeeRepository;


@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
	EmployeeRepository empRepo;
	
	

	public DevBootstrap(EmployeeRepository empRepo) {
		super();
		this.empRepo = empRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initData();
		
	}
	
	private void initData(){
		Employee emp1 = new Employee(1, "Jon", "Gaskar", new BigDecimal(1000.00));
		Employee emp2 = new Employee(2, "Prasad", "Kanamatreddy", new BigDecimal(1400.00));
		Employee emp3 = new Employee(3, "Marcus", "Meadley", new BigDecimal(1600.00));
		Employee emp4 = new Employee(4, "Travis", "Head", new BigDecimal(1800.00));
		
		empRepo.saveAll(Arrays.asList(emp1, emp2, emp3, emp4));
	}
	
	

}
