package com.ymedialabs.ci.cd.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SFOpenIdException extends RuntimeException {

	private static final long serialVersionUID = -3818588426255262649L;

	public SFOpenIdException() {
		super();
	}

	public SFOpenIdException(String message) {
		super(message);
	}

	public SFOpenIdException(String message, Throwable cause) {
		super(message, cause);
	}
}
