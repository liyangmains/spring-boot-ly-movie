package com.ly.server;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
//这个注解给我们绑定消息通道的，Source是Stream给我们提供的，可以点进去看源码，可以看到output和input,这和配置文件中的output，input对应的
@EnableBinding(Source.class)
public class SendServer {
	
	@Autowired
	private Source source;
	
	public void Send(String message){
		source.output().send(MessageBuilder.withPayload(message).build());
	}
}
