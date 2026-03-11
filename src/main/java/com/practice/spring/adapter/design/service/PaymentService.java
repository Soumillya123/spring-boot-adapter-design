package com.practice.spring.adapter.design.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.practice.spring.adapter.design.adapters.GpayAdapter;
import com.practice.spring.adapter.design.adapters.PaypalAdapter;
import com.practice.spring.adapter.design.adapters.StripeAdapter;
import com.practice.spring.adapter.design.exception.AdapterNotFoundException;
import com.practice.spring.adapter.design.processor.PaymentProcessor;
import com.practice.spring.adapter.design.request.PaymentRequest;
import com.practice.spring.adapter.design.response.PaymentResponse;

@Service
public class PaymentService {
	/*
	 * @Autowired private GpayService gPayService;
	 * 
	 * @Autowired private PaypalService payPalService;
	 * 
	 * @Autowired private StripeService stripeServiceService;
	 */
	private Map<String,PaymentProcessor>paymentProcessorMap; 
	
	public PaymentService(List<PaymentProcessor> paymentProcessors) {
		
		paymentProcessorMap=paymentProcessors.stream()
				.collect(Collectors.toMap(processor->processor.getClass().getSimpleName(),Function.identity()));
	}
	
	
	
	public PaymentResponse processPayment(PaymentRequest paymentRequest,String gateway) {
		PaymentProcessor paymentProcessor=paymentProcessorMap.get(gateway+"Adapter");
		if (Optional.ofNullable(paymentProcessor) != null) {
            throw new AdapterNotFoundException("Payment gateway '" + gateway + "' not supported.");
        }
		
		paymentProcessor.makePayment(paymentRequest.amount());
		return new PaymentResponse(true, new Random().nextLong(1000000000L));
	}

	/*private PaymentProcessor getPaymentProcessorInstance(String gateway) {
		PaymentProcessor paymentProcessor=null;
		switch (gateway.toLowerCase()) {
		 case "paypal":
			 paymentProcessor=new PaypalAdapter();
			 break;
		 case "gpay":
			 paymentProcessor=new GpayAdapter();
			 break; 
		case "stripe":
			paymentProcessor=new StripeAdapter();
			break;
	}
    return paymentProcessor;
	
	}*/
}
