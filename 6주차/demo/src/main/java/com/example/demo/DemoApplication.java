package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(DemoApplication.class, args);

		MemberService memberService = ac.getBean(MemberService.class);

		System.out.println("----------------------------------------");
		System.out.println("컨테이너에서 가져온 memberService: " + memberService);
		System.out.println("----------------------------------------");
	}
}