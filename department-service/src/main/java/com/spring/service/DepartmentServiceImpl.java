package com.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.entity.Department;
import com.spring.exception.DepartmentNotFoundException;
import com.spring.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository; 
	
	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	public Department addDepartment(Department department) {
		return this.departmentRepository.save(department);
	}
	
	@Override
	public Department getDepartmentById(Integer id) throws DepartmentNotFoundException {
		Optional<Department> optDept = this.departmentRepository.findById(id);
		if(optDept.isEmpty()) {
			throw new DepartmentNotFoundException(404, "Department not found");
		}
		return optDept.get();
	}
}
