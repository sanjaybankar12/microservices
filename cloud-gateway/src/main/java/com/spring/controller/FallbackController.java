package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@RequestMapping("/fallbackUserService")
	public String fallbackUserService() {
		return "User service is not working currently! Please try later";
	}
	
	@RequestMapping("/fallbackDepartmentService")
	public String fallbackDepartmentService() {
		return "Department service is not working currently! Please try later";
	}
}
