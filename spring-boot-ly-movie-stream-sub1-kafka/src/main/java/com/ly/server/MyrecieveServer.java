package com.ly.server;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.ly.myInput.MyServer;

@EnableBinding(MyServer.class)
public class MyrecieveServer {

	@StreamListener(MyServer.INPUT)
	public void input(String message){
		System.out.println("自定义消息:"+message);
	}
}
