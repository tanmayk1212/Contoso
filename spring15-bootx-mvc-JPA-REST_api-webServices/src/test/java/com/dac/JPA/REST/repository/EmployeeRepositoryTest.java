package com.dac.JPA.REST.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest		// this annotation we use to do testing with real object not Mock objs means test interact with DB 
class EmployeeRepositoryTest {

	@Autowired 
	EmployeeRepository empRepository;
	 
	
	@Test
	void testIsEmployeeExixtById() {
		
		// Actual result
		boolean actualResult = empRepository.isEmployeeExixtById(7);
		
		assertThat(actualResult).isTrue();
		//assertThat(actualResult).isFalse();
	}
	
	@AfterEach
	void tearDown() {
		// ITS LIKE AOP after each method is preformed this method will executeS
		System.out.println("tear down..");	// demo perpose only
		
		// WE use this to remove mock deta after a method is performed
		
		//example---- this will delete all/some data after the methods is done testing
		//empRepository.deleteAll();
		empRepository.deleteById(4);
		
		// BUT ITS NOT LIMITED FOR DELETE OPERATION ONLY
	}
	
	//@BeforeAll
	@BeforeEach
	void setUp() {
		// with this annotation this method will execute before all methods
		// and do some work for us
		// ITS LIKE AOP 
		System.out.println("setting up..");
		
		// We might use this to feed data for each method befor its running
	}

}
