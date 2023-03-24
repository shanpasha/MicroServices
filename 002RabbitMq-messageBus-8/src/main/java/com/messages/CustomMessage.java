package com.messages;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomMessage {
	
	
	String messageId;
	String message;
	Date messageDate;
	

}
