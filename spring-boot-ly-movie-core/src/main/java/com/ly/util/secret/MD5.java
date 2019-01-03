package com.ly.util.secret;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

/**
 * MD5 加密
 */
public class MD5 {
	private static final String Salt = "Huixin.com-!@#$%";
	
	public static String MD5encryption(String origin){
		return MD5encryption(origin,null);
	}
	
	public static String MD5encryption(String origin, String extSalt){
		if(extSalt == null){
			extSalt = "";
		}
		String salt = Salt + extSalt;
		
		Md5PasswordEncoder md5=new Md5PasswordEncoder();
		String md5Password = md5.encodePassword(origin,salt);
		
		return md5Password;
	}
	
	public static String getSalt(){
		return Salt;
	}
//	public static void main(String[] args) {
//		System.out.println(MD5encryption("123456"));
//	}
}
