package com.example.demo.class5.config;

import com.example.demo.class5.package1.MemberRepository;
import com.example.demo.class5.package1.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepository();  // 5주차 Main.java의 new와 동일
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());  // 직접 조립
    }
}