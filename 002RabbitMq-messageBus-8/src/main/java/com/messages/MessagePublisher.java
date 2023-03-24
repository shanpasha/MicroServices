package com.messages;

import java.util.Date;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagePublisher {
	@Autowired
	RabbitTemplate template;
	
	@PostMapping("/poblish")
	public String publishMessage(@RequestBody CustomMessage message) {
		
		message.setMessageId(UUID.randomUUID().toString());
		message.setMessageDate(new Date());
		template.convertAndSend(MqConfig.EXCHANGE,MqConfig.ROUTING_KEY,message);
		
		
		return "message published";
		
	}

}
