package com.vignesh.springboot_playground.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.springboot_playground.model.SampleEntity;

@RestController
@RequestMapping(value="/dummy")
public class DummyController {

	@GetMapping
	public String get() {
		return "This is the default GET response message from the server.";
	}
	
	@PostMapping
	public ResponseEntity<SampleEntity> post(@RequestBody SampleEntity request) {
		request.setId(1);
		return new ResponseEntity<SampleEntity>(request,HttpStatus.CREATED);
	}
}
