package com.example.demo.class5.config;

import com.example.demo.class5.package2.MemberRepository;
import com.example.demo.class5.package2.MemberService;
import com.example.demo.class5.package2.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}