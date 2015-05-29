package com.krishnan.balaji.utils;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	private static final long serialVersionUID = 1L;
	private String message;

	public DrawEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String toString() {
		return message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
