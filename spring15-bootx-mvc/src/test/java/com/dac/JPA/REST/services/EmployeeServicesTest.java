package com.dac.JPA.REST.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.dac.JPA.REST.entites.Employee;
import com.dac.JPA.REST.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)		// Whenever we are using any @Mock object this Annotation is needed on class
class EmployeeServicesTest {

	@Mock			// for creating mock object instead of real object because we have tested Repository as a unit erlier
	EmployeeRepository empRepository;	// to create an mock object as we have already tested the repository and we dont want this service tests to directly intercat with database so @Mock annotation 
	
	@Autowired
	EmployeeServices empServices;
	
	@BeforeEach
	void setUp() {
		this.empServices= new EmployeeServices(empRepository);
	}
	
	@Test
	void testGetCompleteEmployee() {
		
		empServices.getCompleteEmployee();		
		verify(empRepository).findAll();	// empRepository is mock obj so from that we will use findAll()
	}
	
	@Test
	void testGetSingleEmplyeeById() {
		empServices.getSingleEmplyeeById(6);	// they are taking mock data so its not interfaring with database
		verify(empRepository).findById(6);
	}

	@Test
	void testAddNewEmployee() {
		Employee emp = new Employee("TestName", "TestMail@test.com", "TestCity");
		empServices.addNewEmployee(emp);
		verify(empRepository).save(emp);
	}

	@Test
	void testDeleteEmployeeById() {
		empServices.deleteEmployeeById(6);
		verify(empRepository).deleteById(6);
	}

	@Test
	void testUpdateEmployee() {
		Employee emp = new Employee("TestName1", "TestMail1@test.com", "TestCity1");
		empServices.updateEmployee(emp, 7);
	}

}
