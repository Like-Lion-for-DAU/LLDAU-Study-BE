package com.springbootbackend.lionspringboot;

import com.springbootbackend.lionspringboot.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LionspringbootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LionspringbootApplication.class, args);


        MemberService memberService = context.getBean(MemberService.class);
        System.out.println("===========================================");
        System.out.println("MemberService Bean 정상 등록됨: " + memberService);
        System.out.println("===========================================");


        System.out.println("등록된 사용자 Bean 목록:");
        for (String name : context.getBeanDefinitionNames()) {
            if (name.startsWith("member") || name.equals("helloController") || name.equals("appConfig")) {
                System.out.println(" - " + name);
            }
        }
        System.out.println("===========================================");
    }
}
