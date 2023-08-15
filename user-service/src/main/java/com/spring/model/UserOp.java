package com.spring.model;

import com.spring.entity.Department;
import com.spring.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOp {

	private User user;
	private Department dept;
}
