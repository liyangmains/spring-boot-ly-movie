package com.ly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableTransactionManagerServer
public class MyApplication {

	public static void main(String[] args){
		SpringApplication.run(MyApplication.class,args);
	}
}

/*@SpringBootApplication
@MapperScan(value = {"com.ly.*.dao"})
public class MyApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}
}
*/