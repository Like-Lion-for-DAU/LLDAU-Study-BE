package com.example.member.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Class5.package2.MemberRepository;
import Class5.package2.MemberService;
import Class5.package2.MemoryMemberRepository;

//@Configuration
public class AppConfig {
     @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

}
