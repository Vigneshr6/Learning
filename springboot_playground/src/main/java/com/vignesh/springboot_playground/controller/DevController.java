package com.vignesh.springboot_playground.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/dev")
public class DevController {
	
	@GetMapping
	public String getPage() {
		return "accordion.jsp";
	}

}
