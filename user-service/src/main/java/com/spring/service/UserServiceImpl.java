package com.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.spring.entity.Department;
import com.spring.entity.User;
import com.spring.exception.DepartmentNotFoundException;
import com.spring.exception.UserNotFoundException;
import com.spring.model.UserOp;
import com.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private RestTemplate restTemplate; 

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
	@Override
	public User addUser(User user) {
		return this.userRepository.save(user);
	}
	
	@Override
	public UserOp getUser(Integer id) throws UserNotFoundException, DepartmentNotFoundException {
		UserOp userOp = new UserOp();
		
		Optional<User> optuser = this.userRepository.findById(id);
		if(optuser.isEmpty()) {
			throw new UserNotFoundException(404, "user not found");
		}
		userOp.setUser(optuser.get());
		userOp.setDept(getDepartment(optuser.get().getDeptId()));
		
		return userOp;
	}
	
	private Department getDepartment(Integer id) throws DepartmentNotFoundException {	
		try {
		return this.restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+id, Department.class);
		} catch(RestClientException ex) {
			throw new DepartmentNotFoundException(404, "department not found");
		}
	}
}
