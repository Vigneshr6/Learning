package com.vignesh.springboot_playground.model;

public class EchoRequest {
	private String message;

	public EchoRequest(String message) {
		super();
		this.message = message;
	}

	public EchoRequest() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
