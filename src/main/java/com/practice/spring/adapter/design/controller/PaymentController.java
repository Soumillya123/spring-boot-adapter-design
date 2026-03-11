package com.practice.spring.adapter.design.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.spring.adapter.design.request.PaymentRequest;
import com.practice.spring.adapter.design.response.PaymentResponse;
import com.practice.spring.adapter.design.service.PaymentService;

@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {
	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		
		this.paymentService = paymentService;
	}
	
	@PostMapping
	public ResponseEntity<PaymentResponse>makePayment(@RequestBody PaymentRequest paymentRequest, @RequestParam String gateway ){
		return ResponseEntity.ok(paymentService.processPayment(paymentRequest,gateway)); 
	}

}
