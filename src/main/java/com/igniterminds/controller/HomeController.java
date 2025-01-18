package com.igniterminds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController   // to simplify the creation of RESTful web services
public class HomeController {
	
	@GetMapping
	public String homeControllerHandler() {
		return "This is home controller";
	}
	
	
}
