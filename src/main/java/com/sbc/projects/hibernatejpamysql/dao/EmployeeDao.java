package com.sbc.projects.hibernatejpamysql.dao;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import com.sbc.projects.hibernatejpamysql.models.Employee;
import com.sbc.projects.hibernatejpamysql.repository.EmployeeRepository;

@Repository
public class EmployeeDao implements IEmployeeDao{

	private static final Logger log = Logger.getLogger(EmployeeDao.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	@Override
	public List<Employee> findAll(){
		log.info("Enter findAll method");
		List<Employee> employees = employeeRepository.findAll();

		return employees;
	}

	@Override
	public List<Employee> findByfName(String fName){
		log.info("Enter findByfName method");
		List<Employee> employees = employeeRepository.findByfName(fName);

		return employees;
	}

	@Override
	public List<Employee> findByjobTitle(String jobTitle){
		log.info("Enter findByjobTitle method");
		List<Employee> employees = employeeRepository.findByjobTitle(jobTitle);

		return employees;
	}

	@Override
	public Employee save(@RequestBody Employee employee){
		log.info("Enter saveEmployee method");
		Employee newEmployee = employeeRepository.save(employee);
		return newEmployee;
	}

	@Override
	public boolean DeleteById(int id){	
		log.info("Enter DeleteById method");
		Optional<Employee> emp = employeeRepository.findById(id);
		if( emp.isPresent()){
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean UpdateById(Employee employee){	
		log.info("Enter UpdateById method");
		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		if( emp.isPresent()){
			employeeRepository.save(employee);
			return true;
		}
		return false;
	}

	@Override
	public Optional<Employee> findById(int id){		// Optional handles null return value by employeeRepository.findById(id) method
		log.info("Enter findById method");
		Optional<Employee> newEmployee = employeeRepository.findById(id);

		return newEmployee;
	}


		
	


	

}

