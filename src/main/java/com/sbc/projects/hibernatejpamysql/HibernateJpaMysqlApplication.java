package com.sbc.projects.hibernatejpamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @consumedBy ReactJs. Go to 'C:\Users\Surya Chettri\ReactJs-App\spring-reactjs-app\src>' in Windows CLI.
 * Enter 'npm start'.
 * Open browser in http://localhost:3000'
 *
 */

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.sbc.projects.hibernatejpamysql.repository")
@EntityScan(basePackages="com.sbc.projects.hibernatejpamysql.models")
public class HibernateJpaMysqlApplication {

	/**
	 * Make sure to add these annotation in the Application.run() class,
	 * @EnableJpaRepositories(basePackages="com.sbc.projects.hibernatejpamysql.repository")
	 * @EntityScan(basePackages="com.sbc.projects.hibernatejpamysql.models")
	 * List appropriate spring.datasource information in application.properties file.
	 * MainController --> EmployeeDao --> EmployeeRepository	(flow of Dependency Injection)
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateJpaMysqlApplication.class, args);
	}
}
