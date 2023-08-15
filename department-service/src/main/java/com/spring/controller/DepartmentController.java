package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Department;
import com.spring.exception.DepartmentNotFoundException;
import com.spring.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping
	public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
		return new ResponseEntity<>(this.departmentService.addDepartment(department), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable Integer id) throws DepartmentNotFoundException {
		return new ResponseEntity<>(this.departmentService.getDepartmentById(id), HttpStatus.OK);
	}
}
