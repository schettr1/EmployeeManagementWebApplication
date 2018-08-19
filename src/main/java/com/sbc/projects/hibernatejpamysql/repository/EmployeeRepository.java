package com.sbc.projects.hibernatejpamysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.sbc.projects.hibernatejpamysql.models.Employee;


@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


/**
 * JPA provides this JpaRepository interface that has methods that can perform CRUD operations
 * Using JpaRepository is a short-cut to the conservative way (using hibernate only) of 
 * performing CRUD operations which required Transaction, SessionFactory and Session Objects.
 * Only those methods that are not provided by the JpaRepositoroy 
 * must be list here as abstract methods.
 * eg; findByfName() is a user defined abstract method that must match 'fName' with the 
 * Employee attribute name. If mis-spelled, gives an error while starting the server.
 * Make sure to add these annotation in the Application.run() class,
 * @EnableJpaRepositories(basePackages="com.sbc.projects.hibernatejpamysql.repository")
 * @EntityScan(basePackages="com.sbc.projects.hibernatejpamysql.models")
 * List spring.datasource information in application.properties file.
 * @Component must be annotated to this interface
 */
	
	public List<Employee> findByfName(String fName);
	public List<Employee> findByjobTitle(String jobTitle); 

	 
	
/*	public List<Employee> findAll();
	public Employee save(Employee employee);
	public Optional<Employee> findById(int id);
	public boolean deleteById(int id);*/
}
