package com.vignesh.springboot_playground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vignesh.springboot_playground.model.EchoRequest;

@RestController
@RequestMapping(value="/echo")
public class EchoController {

	@GetMapping(value="/{input}")
	public String echoGET(@PathVariable(name="input") String input) {
		return input;
	}
	
	@PostMapping
	public String echoPOST(@RequestBody EchoRequest request) {
		return request.getMessage();
	}
}
