package com.sbc.projects.hibernatejpamysql.exceptions;

public class UserNotCreatedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotCreatedException(String message){
		super(message);
	}
}
