package com.practice.spring.adapter.design.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdapterNotFoundException extends RuntimeException {
	public AdapterNotFoundException(String msg) {super(msg);}

}
