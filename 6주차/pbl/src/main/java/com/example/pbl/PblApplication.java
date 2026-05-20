package com.example.pbl;

import com.example.pbl.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PblApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(PblApplication.class, args);

		MemberService service =
				context.getBean(MemberService.class);

		System.out.println(service);
	}
}