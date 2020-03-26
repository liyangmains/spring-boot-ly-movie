package com.ly.mySource;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Mysource {
	
	@Output("myOutput")
	MessageChannel myOutput();

}
