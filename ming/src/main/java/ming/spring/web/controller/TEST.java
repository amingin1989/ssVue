package ming.spring.web.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String encoded=new BCryptPasswordEncoder().encode("admin123");
		String encoded2=new BCryptPasswordEncoder().encode("user123");
		System.out.println(encoded);
		System.out.println(encoded2);
	}

}
