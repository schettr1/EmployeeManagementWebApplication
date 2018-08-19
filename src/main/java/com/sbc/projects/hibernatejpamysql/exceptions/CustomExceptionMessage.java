package com.sbc.projects.hibernatejpamysql.exceptions;

import java.util.Date;

public class CustomExceptionMessage {

	private String message;
	private Date timestamp;
	private String code;
	
	public CustomExceptionMessage() {

	}
	
	public CustomExceptionMessage(String message, Date timestamp, String code) {
		this.message = message;
		this.timestamp = timestamp;
		this.code = code;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}


}
