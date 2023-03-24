package com.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.messages.CustomMessage;
import com.messages.MqConfig;
@Component
public class Consumer {

	@RabbitListener(queues=MqConfig.QUEUE)
	
	public void ConsumerMessageFrom(CustomMessage messageStatus) {
		
		System.out.println("message Status "+messageStatus);
	}
	
	
}
