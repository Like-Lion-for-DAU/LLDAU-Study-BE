package com.likelion.pbl;

import com.likelion.pbl.member.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PblApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(PblApplication.class, args);

        MemberService memberService = applicationContext.getBean(MemberService.class);
        System.out.println("memberService = " + memberService.getClass().getName());
    }
}
