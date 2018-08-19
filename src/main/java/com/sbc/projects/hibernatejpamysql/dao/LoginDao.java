package com.sbc.projects.hibernatejpamysql.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sbc.projects.hibernatejpamysql.models.Login;
import com.sbc.projects.hibernatejpamysql.repository.LoginRepository;

@Repository
public class LoginDao {

	@Autowired
	LoginRepository loginRepository;
	
	@SuppressWarnings("unchecked")
	public void UpdatePassword(Login login){
		loginRepository.save(login);
	}
}
