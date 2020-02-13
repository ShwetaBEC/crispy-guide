package com.ymedialabs.ci.cd.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class CareConnectNoAuthException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CareConnectNoAuthException(String message) {
		super(message);
	}

	public CareConnectNoAuthException(String message, Throwable cause) {
		super(message, cause);
	}
}
