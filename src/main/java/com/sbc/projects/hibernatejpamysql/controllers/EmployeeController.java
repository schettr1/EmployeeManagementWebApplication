package com.sbc.projects.hibernatejpamysql.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sbc.projects.hibernatejpamysql.dao.EmployeeDao;
import com.sbc.projects.hibernatejpamysql.exceptions.EmployeeNotFoundException;
import com.sbc.projects.hibernatejpamysql.exceptions.UserNotCreatedException;
import com.sbc.projects.hibernatejpamysql.models.Employee;

/**
 * 
 * @consumedBy ReactJs. Go to 'C:\Users\Surya Chettri\ReactJs-App\spring-reactjs-app\src>' in Windows CLI.
 * Enter 'npm start'.
 * Open browser in http://localhost:3000'
 *
 */


@RestController
@CrossOrigin(origins={"http://localhost:4200", "http://localhost:3000"})	// @CrossOrigin annotation is used to indicate that this service will be consumed by these URLs
public class EmployeeController {

	private static final Logger log = Logger.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	/* Find all Employees */	
	@GetMapping(value="/employees")
	public List<Employee> findAllEmployees(){
		List<Employee> employees = new ArrayList<>();
		employees = employeeDao.findAll();
		if(employees.isEmpty()){
			log.error("Employees Not Found");
			throw new EmployeeNotFoundException("Employees Not Found");
		}
		else{
			log.info("Employees list is Found");
		}
		return employees;
	}
	
	
	/* Find Employees by First Name*/
	@GetMapping(value="/employees/fname/{fName}")
	public List<Employee> findEmployeesByFirstName(@PathVariable String fName){
		List<Employee> employees = new ArrayList<>();
		employees = employeeDao.findByfName(fName);
		if(employees.isEmpty()){
			log.error("Employees with first name " + fName + " Not Found");
			throw new EmployeeNotFoundException("Employees with First Name '" + fName + "' Not Found");
		}
		else{
			log.info("Employee with first name " + fName + " Found");
		}
		return employees;
	}
	
	
	/* Find Employees by jobTitle */
	@GetMapping(value="/employees/jobTitle/{jobTitle}")
	public List<Employee> findEmployeesByjobTitle(@PathVariable String jobTitle){
		List<Employee> employees = new ArrayList<>();
		employees = employeeDao.findByjobTitle(jobTitle);
		if(employees.isEmpty()){
			log.error("Employees with jobTitle " + jobTitle + " Not Found");
			throw new EmployeeNotFoundException("Employees with jobTitle '" + jobTitle + "' Not Found");
		}
		else{
			log.info("Employee with jobTitle " + jobTitle + " Found");
		}
		return employees;
	} 
	
	
	/* Create New Employee */
	@PostMapping(value="/employees")
	public ResponseEntity<Object> createNewEmployee(@RequestBody Employee employee){
		Employee emp = new Employee();
		emp = employeeDao.save(employee);
		if (emp == null){
			log.error("Invalid request; " + employee + " is not a valid input");
			throw new UserNotCreatedException("Invalid request; " + employee + " is not a valid input");
		}
		else{
			log.info("New Employee with id " + emp.getId() + " Created"); 
		}
		/* Using HATEOAS, return the link to the newly created employee as response */
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();
		return new ResponseEntity<Object>(location, HttpStatus.OK); // returns a 'Status: 200 OK' with a body message
	}
	
	
	/* Find Employee By ID */
	@GetMapping(value="/employees/{id}")
	public Optional<Employee> findEmployeeById(@PathVariable int id){
		log.info("Enter Controller:findEmployeeById method");
		Optional<Employee> emp = employeeDao.findById(id);
		if (!emp.isPresent()){
			log.error("Employees with id: " + id + " Not Found");
			throw new EmployeeNotFoundException("Employees with id '" + id + "' Not Found");
		}
		else{
			log.info("Employees with id " + id + " Found");
		}
		return emp;
	}
	
	
	/* Delete Employee By ID */
	@DeleteMapping(value="employees/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id){
		boolean resp = false;
		resp = employeeDao.DeleteById(id);
		if (resp == false){
			log.error("Employees with id: " + id + " Not Found"); 
			throw new EmployeeNotFoundException("Employees with id '" + id + "' Not Found");
		}
		else{
			log.info("Employees with id " + id + " Deleted");
		}
		return ResponseEntity.noContent().build();		// returns status: '204 No Content' i.e. The server processed the request successfully but is not returning any content. 
	}
	
	
	/* Update Employee By ID */
	@PutMapping(value="employees")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee){
		boolean resp = false;
		resp = employeeDao.UpdateById(employee);
		if (resp == false){
			log.error("Employees with id: " + employee.getId() + " Not Found"); 
			throw new EmployeeNotFoundException("Employees with id '" + employee.getId() + "' Not Found");
		}
		else{
			log.info("Employees with id: " + employee.getId() + " Updated"); 
		}
		
		/* Using HATEOAS, return the link to the updated employee as a response */
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
		return new ResponseEntity<Object>(location, HttpStatus.OK); // returns a 'Status: 200 OK' with a body message
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * Insert thymeleaf dependency in pom.xml file.
	 * Thymeleaf is used to render views and is considered similar to JSP (Java Server Page)
	 * ViewController (@Controller) is used to render views/pages that are 
	 * inside src/main/resources folder.
	 * This controller will return index.html page for default url i.e. http://localhost:8080/
	 *
	
		@Controller
		public class ViewController {
		
			@GetMapping(value="/")
			public String index(){
				return "index";
			}
		}
	 * 
	 * 
	 * 
	 */
	
	
	
	
	
	
	
	
	
	
