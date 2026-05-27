package com.springbootbackend.lionspringboot;

import com.springbootbackend.lionspringboot.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LionspringbootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LionspringbootApplication.class, args);


    }
}
