package com.spring.service;

import com.spring.entity.Department;
import com.spring.exception.DepartmentNotFoundException;

public interface DepartmentService {

	Department addDepartment(Department department);

	Department getDepartmentById(Integer id) throws DepartmentNotFoundException;

}
