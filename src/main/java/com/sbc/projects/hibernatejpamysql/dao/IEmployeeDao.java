package com.sbc.projects.hibernatejpamysql.dao;

import java.util.List;
import java.util.Optional;

import com.sbc.projects.hibernatejpamysql.models.Employee;

public interface IEmployeeDao {

	public List<Employee> findAll();
	
	public List<Employee> findByfName(String fName);

	public List<Employee> findByjobTitle(String jobTitle);

	public Employee save(Employee employee);

	public Optional<Employee> findById(int id);

	public boolean DeleteById(int id);
	
	public boolean UpdateById(Employee employee);

}