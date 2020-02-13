package com.ymedialabs.ci.cd.sample.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymedialabs.ci.cd.sample.service.UserService;
import com.ymedialabs.ci.cd.sample.utils.SFOpenIdResponseEntity;

@RestController
@RequestMapping(value = "/")
public class UserController {

	@Inject
	private UserService userService;

	@GetMapping(value = "/view")
    public SFOpenIdResponseEntity<String> getMessage() {
        return new SFOpenIdResponseEntity<>(userService.getMessage());
    }
}
