package com.likelion.pbl.config;

import com.likelion.pbl.repository.MemberRepository;
import com.likelion.pbl.repository.MemoryMemberRepository;
import com.likelion.pbl.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * To test manual bean registration, uncomment @Configuration below.
 * Also comment out @Repository on MemoryMemberRepository and @Service on MemberService.
 */
// @Configuration
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
