package com.example.pbl.config;

import com.example.pbl.repository.MemberRepository;
import com.example.pbl.repository.MemoryMemberRepository;
import com.example.pbl.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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