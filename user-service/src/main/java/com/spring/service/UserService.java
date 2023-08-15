package com.spring.service;

import com.spring.entity.User;
import com.spring.exception.UserNotFoundException;
import com.spring.model.UserOp;

public interface UserService {

	User addUser(User user);

	UserOp getUser(Integer id) throws UserNotFoundException;

}
