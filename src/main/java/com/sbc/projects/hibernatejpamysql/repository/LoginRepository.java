package com.sbc.projects.hibernatejpamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sbc.projects.hibernatejpamysql.models.Login;

@Component
public interface LoginRepository extends JpaRepository<Login, String> {

	
}
