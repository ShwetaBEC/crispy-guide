package com.ymedialabs.ci.cd.sample.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -4680841056160180886L;

	public BadRequestException(String message) {
		super(message);
	}
}
