package com.example.member;

import com.example.member.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MemberApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(MemberApplication.class, args);
		MemberService memberService = applicationContext.getBean(MemberService.class);
		System.out.println("memberService = " + memberService);
	}

}
