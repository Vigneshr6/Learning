package com.vignesh.springboot_playground.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/dev")
public class DevController {
	
	private static final Logger log = LoggerFactory.getLogger(DevController.class);
	
	@GetMapping
	public String getPage() {
		return "accordion.jsp";
	}
	
	@GetMapping("/debug")
	public void debugController(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		log.debug("cookies : "+cookies.length);
		for(Cookie c:cookies)
			log.debug(c.getName()+" -- "+c.getValue());
	}

}
