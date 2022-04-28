package com.dac.JPA.REST.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dac.JPA.REST.entites.Employee;
														// entity class // id dtype
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	// for this application we will not need our own methods
	
	//--------------------------------------------
	// Demo function for demo testing and built in methods does not need testing but they can be tested too
	// to show how we will do testing if there is a function in repository and we need to test it
	// to see if a employee is available of not
								// s is obj															// here we can use SQL query as well
	@Query("select case when count(s)>0 then true else false end from Employee s where s.id=?1")	// JPQL Query to see if employee exist or not if not then false and if then true
	Boolean isEmployeeExixtById(Integer id);				// Entity name	 s is obj 
	
}
