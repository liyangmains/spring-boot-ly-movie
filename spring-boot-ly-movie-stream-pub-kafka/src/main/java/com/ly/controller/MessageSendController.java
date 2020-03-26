package com.ly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ly.server.MySendServer;
import com.ly.server.SendServer;

@RestController
public class MessageSendController {

	@Autowired
	private SendServer sendServer;
	@Autowired
	private MySendServer mySendServer;
	
	@GetMapping("message/{msg}")
	public String messageSend(@PathVariable("msg") String msg){
		try {
			sendServer.Send(msg);
		} catch (Exception e) {
			return "发送消息失败!";
		}
		
		return "发送消息成功!";
	}
	@GetMapping("myMessage/{msg}")
	public String myMessageSend(@PathVariable("msg") String msg){
		try {
			mySendServer.Send(msg);
		} catch (Exception e) {
			return "发送消息失败!";
		}
		
		return "发送消息成功!";
	}
}
