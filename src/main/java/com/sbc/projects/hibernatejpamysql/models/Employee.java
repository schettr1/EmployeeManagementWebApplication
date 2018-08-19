package com.sbc.projects.hibernatejpamysql.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String fName;
	
	private String lName;
	
	private String jobTitle;
	
	private String email;
	
	private String image;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="username_FK")
	private Login login;
	
	
	public Employee() {

	}

	
	public Employee(int id, String fName, String lName, String jobTitle, String email, String image) {
		
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.jobTitle = jobTitle;
		this.image = image;
		this.setEmail(email);
	}


	public Employee(int id, String fName, String lName, String jobTitle, String email, String image, Login login) {

		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.jobTitle = jobTitle;
		this.setEmail(email);
		this.image = image;
		this.login = login;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getjobTitle() {
		return jobTitle;
	}

	public void setjobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName + ", jobTitle=" + jobTitle + ", email="
				+ email + ", image=" + image + ", login=" + login + "]";
	}


	
}
