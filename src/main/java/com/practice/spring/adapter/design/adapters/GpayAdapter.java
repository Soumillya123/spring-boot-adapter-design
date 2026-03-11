package com.practice.spring.adapter.design.adapters;

import org.springframework.stereotype.Component;

import com.practice.spring.adapter.design.processor.PaymentProcessor;

@Component
public class GpayAdapter implements PaymentProcessor {
	public void makePayment(double amount) {
        // PayPal-specific logic to process payment
        //actual api
        System.out.println("Payment processed via GPay: " + amount);
 }
}
