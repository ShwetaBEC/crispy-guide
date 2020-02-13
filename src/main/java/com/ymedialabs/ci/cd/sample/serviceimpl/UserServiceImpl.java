package com.ymedialabs.ci.cd.sample.serviceimpl;

import org.springframework.stereotype.Service;

import com.ymedialabs.ci.cd.sample.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Override
	public String getMessage() {
				
		return "Welcome to Java application";
	}

}
