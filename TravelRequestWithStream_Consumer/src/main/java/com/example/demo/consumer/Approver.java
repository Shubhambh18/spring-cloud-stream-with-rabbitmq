package com.example.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import com.example.demo.TravelRequestWithStreamConsumerApplication;
import com.example.demo.model.TravelRequest;

@EnableBinding(Sink.class)
@Component				// We didn't want to create new controller just to call the receiveRequest function
public class Approver {

	
	@Autowired
	private Sink sink;
	
	@StreamListener(target = Sink.INPUT)
	public void receiveRequest(TravelRequest request) {
		 System.out.println("One request With Details " + request + " Approved");
	}
}
