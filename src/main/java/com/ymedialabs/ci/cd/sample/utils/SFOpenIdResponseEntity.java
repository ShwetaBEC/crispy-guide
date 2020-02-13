package com.ymedialabs.ci.cd.sample.utils;

import lombok.Data;

@Data
public class SFOpenIdResponseEntity<T> {

	private T data;

	private String message;
	
	public SFOpenIdResponseEntity(T data){
		this.data = data;
	}
	
	public SFOpenIdResponseEntity(String message){
		this.message = message;
	}
}
