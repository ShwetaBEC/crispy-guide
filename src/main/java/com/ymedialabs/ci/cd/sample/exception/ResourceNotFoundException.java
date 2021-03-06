package com.ymedialabs.ci.cd.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6966333878935434338L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
