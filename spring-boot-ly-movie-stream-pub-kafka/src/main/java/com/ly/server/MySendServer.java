package com.ly.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import com.ly.mySource.Mysource;

@EnableBinding(Mysource.class)
public class MySendServer {

	@Autowired
	private Mysource mysourece;
	
	public void Send(String message){
		mysourece.myOutput().send(MessageBuilder.withPayload(message).build());
	}
}
