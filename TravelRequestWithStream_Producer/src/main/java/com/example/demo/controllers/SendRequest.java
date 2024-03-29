package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TravelRequest;

@RestController
@EnableBinding(Source.class)
public class SendRequest {

	@Autowired
	private Source source;
//	
//	@PostMapping("/makeRequest")
//	public String dispatchRequest(@RequestBody TravelRequest request) {
//		source.output().send(MessageBuilder.withPayload(request).build());
//		
//		System.out.println();
//		return "One Request Sent";
//	}
	
//	
	@GetMapping("/makeRequest")
	public String dispatchRequest() {
		TravelRequest request = new TravelRequest(102,2633407,"Shubham","A2",25000.65,"Client Meeting");
		source.output().send(MessageBuilder.withPayload(request).build());
		return "One Request Sent";
	}
	
	
}
