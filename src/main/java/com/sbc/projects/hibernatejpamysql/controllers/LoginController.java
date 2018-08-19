package com.sbc.projects.hibernatejpamysql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sbc.projects.hibernatejpamysql.dao.LoginDao;
import com.sbc.projects.hibernatejpamysql.models.Login;

@RestController
public class LoginController {

	@Autowired
	LoginDao loginDao;
	
	/* Update Password */
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping(value="login")
	public void updatePassword(@RequestBody Login login){
		loginDao.UpdatePassword(login);
		
	}
	
}
