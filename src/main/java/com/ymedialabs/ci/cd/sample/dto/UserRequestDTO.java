package com.ymedialabs.ci.cd.sample.dto;

import javax.validation.constraints.Email;

import org.springframework.lang.NonNull;

import lombok.Data;

@Data
public class UserRequestDTO {

	@NonNull
	@Email
	private String email;
	
	@NonNull
	private String password;
	
}
