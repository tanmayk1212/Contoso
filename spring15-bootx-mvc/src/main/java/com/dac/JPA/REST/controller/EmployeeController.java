package com.dac.JPA.REST.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dac.JPA.REST.entites.Employee;
import com.dac.JPA.REST.entites.User;
import com.dac.JPA.REST.services.EmployeeServices;
import com.dac.JPA.REST.services.UserService;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;

/*

//@Controller	when we are using String Boot or soring boot JPA without REST Api
@RestController			// when using String Boot with Rest Api
public class EmployeeController {

	
	@Autowired					// this annotation is used to create objects of @component/@service/@Repository class
	EmployeeServices empServices;
	
	
	//-------------------------
	// FETCHING ALL RECORDS...
	
	//@RequestMapping(path="/employee", method = RequestMethod.GET)		we can use this to map request with Get method
	@GetMapping("/employee")		// Rest api provide this annotation with automatically specifies Get method type of request provided
	//@ResponseBody				// to return string insted of jsp file used when using @Controller but not needed if using @RestController
	public List<Employee> getAllEmployee() {
		
		List<Employee> list = empServices.getCompleteEmployee();
		
		return list;
	}
	
	//------------------------
	// FETCHING SINGLE RECORD BY ID
	
	@GetMapping("/employee/{id}")			// users Get request by passing id
	public Optional<Employee> getSingleEmployee(@PathVariable("id") int id) {	// path variable because we are getting dtata from view or user
		
		Optional<Employee> emp = empServices.getSingleEmplyeeById(id);
		return emp;
	}
	
	//---------------------------
	// INSERTING A RECORD
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee emp) {
		
		Employee empObj = empServices.addNewEmployee(emp);
		return empObj;
	}
	
	// DELETE A RECORD
	
	@DeleteMapping("/employee/{id}")		// for delete request this tahg is used equivalent to @RequestMapping(path="/employee", method = RequestMethod.DELETE)	
	public void deleteEmployee(@PathVariable("id") int id) {	// path variable is used to fetch data from user view equivatent to request.getParam() of servlet
		
		this.empServices.deleteEmployeeById(id);
		// not returning anything
	}
	
	//UPDATE BY ID
	
	@PutMapping("/employee/{id}")			// This annotation is for update 
	public void updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
								//@RequestBody will get obj of user updated record from user form, @PathVariable this will get id from user form
		this.empServices.updateEmployee(emp, id);	// emp will hold user updated record ,id is the id of that record
	}
}








***************************************************************************************
*************	MODIFYING CONTROLLER TO GIVE STATUS CODE BACK  ***********
 * ----ITS VERY GOOD PRACTICE TO RETURN STATUS CODE IT HELPS USER---
 * ---- TO UNDERSTAND THE PROBLEM OR PROGRESS------
 * 
 * ---  NOT VERY MUCH DIFFRENCE with above & above is also working fine--
*/




//@Controller	when we are using String Boot or soring boot JPA without REST Api
@RestController			// when using String Boot with Rest Api
public class EmployeeController {

	
	@Autowired					// this annotation is used to create objects of @component/@service/@Repository class
	EmployeeServices empServices;
	
	@Autowired
	UserService usrService;
	
	
	//-------------------------
	// FETCHING ALL RECORDS...
	
	//@RequestMapping(path="/employee", method = RequestMethod.GET)		we can use this to map request with Get method
	@GetMapping("/employee")		// Rest api provide this annotation with auto matically specifies Get method type of request provided
	//@ResponseBody				// to return string insted of jsp file used when using @Controller but not needed if using @RestController
	public ResponseEntity<List<Employee>> getAllEmployee() {
			// ResponseEntity to return status
		
		List<Employee> list = empServices.getCompleteEmployee();
		
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	//------------------------
	// FETCHING SINGLE RECORD BY ID
	
	@GetMapping("/employee/{id}")			// users Get request by passing id
	public ResponseEntity<Optional<Employee>> getSingleEmployee(@PathVariable("id") int id) {	// path variable because we are getting dtata from view or user
		
		Optional<Employee> emp = empServices.getSingleEmplyeeById(id);
		
		if(emp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(emp));
	}
	
	//---------------------------
	// INSERTING A RECORD
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		
			try {
				Employee empObj = empServices.addNewEmployee(emp);
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}catch(Exception e) {
				e.getStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}
	
	// DELETE A RECORD
	
	@DeleteMapping("/employee/{id}")		// for delete request this tahg is used equivalent to @RequestMapping(path="/employee", method = RequestMethod.DELETE)	
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") int id) {	// path variable is used to fetch data from user view equivatent to request.getParam() of servlet
						// Void is class here
		try{
			this.empServices.deleteEmployeeById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
	
		}catch(Exception e) {
			e.getStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//UPDATE BY ID
	@PutMapping("/employee/{id}")			// This annotation is for update 
	public ResponseEntity<Void> updateEmployee(@RequestBody Employee emp, @PathVariable("id") int id) {
								//@RequestBody will get obj of user updated record from user form, @PathVariable this will get id from user form
		try{
			this.empServices.updateEmployee(emp, id);	// emp will hold user updated record ,id is the id of that record
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}catch(Exception e) {
			e.getStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}										// INTERNAL_SERVER_ERROR or ANYHING ELSE IS UPTO PROGRAMMER BUT it shoud give info about problem
	}
	
	
	// bajaj Qualifire1
	@SuppressWarnings("unchecked")
	@PostMapping("/bfhl")
	public ArrayList<String> acceptUser(@RequestBody User usr) {
		
			try {
				 @SuppressWarnings("rawtypes")
				List list = new ArrayList<>();
				 @SuppressWarnings("unused")
				String[] data = usrService.getCompleteEmployee();
				 
				 String[] numbers = new String[5];
				 String[] alphabets = new String[5];
				 int a=0,b=0;
				 for(String elm: data) {
					 String sample = elm;
					 char ch = sample.charAt(0);
					 if(Character.isDigit(ch)) {
						 alphabets[a] = Character.toString(ch);
						 a++;
					 }else {
						 numbers[b] = Character.toString(ch);
					 }
				 }
				 list.add("true");
				 list.add("john_doe_123456");
				 list.add("john@xml.com");
				 list.add("ABCD12345");				 
				 ArrayList<String> updatableList = new ArrayList<String>();
				    updatableList.addAll(list); 
				    updatableList.add("[1, 334, 4]");
				    updatableList.add("[A, R]");
				 return updatableList;
			}catch(Exception e) {
				e.getStackTrace();
			}
			return null;
		}
}

