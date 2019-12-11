package com.e1708.cms.service;

import javax.validation.Valid;

import com.e1708.cms.entity.User;

public interface UserService {

	User getUserByUsername(String username);

	int register(@Valid User user);

}
