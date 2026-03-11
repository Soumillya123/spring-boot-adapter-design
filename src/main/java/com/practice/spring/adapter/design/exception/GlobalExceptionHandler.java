package com.practice.spring.adapter.design.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(AdapterNotFoundException.class)
	public ResponseEntity<ErrorResponseModel> handleAdaptorNotFound(AdapterNotFoundException adpException){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseModel(adpException.getMessage(),404,LocalDateTime.now()) );
	}

}
