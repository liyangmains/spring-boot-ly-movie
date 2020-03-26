package com.ly.myInput;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MyServer {

	String INPUT="myInput";
	
	@Input(MyServer.INPUT)
	SubscribableChannel input();
}
