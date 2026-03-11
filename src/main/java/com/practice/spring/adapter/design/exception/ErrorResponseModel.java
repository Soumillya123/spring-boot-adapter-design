package com.practice.spring.adapter.design.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseModel {
private String message;
private int status;
private LocalDateTime timeStamp;
}
