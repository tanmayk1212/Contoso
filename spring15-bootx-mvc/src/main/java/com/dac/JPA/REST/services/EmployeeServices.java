package com.dac.JPA.REST.services;


import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.JPA.REST.entites.Employee;
import com.dac.JPA.REST.repository.EmployeeRepository;

//(if these annotation is not @Autowired cannot create object of this class)

// --------- THESE ANNOTATIONS ARE EQUVIVALENT ---------
@Service					// using spring boot with REST so we use this annotation	
public class EmployeeServices {

	@Autowired
	private EmployeeRepository empRepository;
	
	public EmployeeServices(EmployeeRepository empRepository) {
		this.empRepository = empRepository;
	}

	// for all employee
	public List<Employee> getCompleteEmployee() {
		
		List<Employee> list =(List<Employee>) empRepository.findAll();	
											// findAll() JPA methods equivalent to (select* from tableName)
		return list;
	}

	// for single employee
	public Optional<Employee> getSingleEmplyeeById(int id) {
		
		Optional<Employee> emp = empRepository.findById(id);
		
		return emp;
	}

	// inserting record
	public Employee addNewEmployee(Employee emp) {
		
		Employee employee1 = empRepository.save(emp);			
		return employee1;
	}

	// deleting by id
	public void deleteEmployeeById(int id) {
		
		this.empRepository.deleteById(id);
		// deleteById() is equvivalent to (delete from tablename where id = id)
	}				
					
	// updateing a record
	public void updateEmployee(Employee emp, int id) {
		
		emp.setId(id);		// just to be sure if wrong id is given
		this.empRepository.save(emp);
		// save() is used for update also JPA does not have special method for Update()
	}	
	
}

