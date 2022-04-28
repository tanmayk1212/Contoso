package com.dac.JPA.REST.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dac.JPA.REST.entites.Employee;
import com.dac.JPA.REST.services.EmployeeServices;

@SpringBootTest		// This annotation we use to do integrated testing means we are doing testing of whole application 
class EmployeeControllerTest {
	
	@Autowired
	EmployeeServices empServices;		// we are creating real obj not mock test obj
	
	
	@Test
	void testGetAllEmployee() {					// this are simple ways that we test but it could be more than this
		List<Employee> list = empServices.getCompleteEmployee();
		assertThat(list).isNotEmpty();
	}

	@Test
	void testGetSingleEmployee() {
		Optional<Employee> list1 = empServices.getSingleEmplyeeById(7);
		assertThat(list1).isNotNull();
	}

// this commented tests cannot be performed at the same time for obvious reasons thats why they are commented
	
//	@Test
//	void testAddEmployee() {
//		Employee emp = new Employee("TestName", "TestMail@test.com", "TestCity");
//		Employee employee1 = empServices.addNewEmployee(emp);
//		assertEquals(emp, employee1);
//	}

//	@Test
//	void testDeleteEmployee() {
//		empServices.deleteEmployeeById(29);
//	}

//	@Test
//	void testUpdateEmployee() {
//		Employee emp = new Employee("NewTester", "NewTesterMail@test.com", "NewTesterCity");
//		empServices.updateEmployee(emp, 30);
//	}

}
