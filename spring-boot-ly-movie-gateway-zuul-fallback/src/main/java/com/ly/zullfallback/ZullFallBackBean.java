package com.ly.zullfallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ZullFallBackBean implements ZuulFallbackProvider{

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
//		return "movie-ribbon-hystrix2"; //代理服务ID,*或者null表示所有代理服务的ID
		return null;
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
			    HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8); //设置头
                return httpHeaders;
			}
			
			@Override
			public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(("后台服务请求错误"+ZullFallBackBean.this.getRoute().toString()).getBytes()); //返回前端的内容
			}
			
			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.value();
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
			}
		};
	}

}
