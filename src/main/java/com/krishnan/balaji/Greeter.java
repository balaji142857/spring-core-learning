package com.krishnan.balaji;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Greeter {

	@Resource
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
