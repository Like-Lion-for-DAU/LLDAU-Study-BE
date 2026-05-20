package com.springbootbackend.lionspringboot.config;




// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

import com.springbootbackend.lionspringboot.repository.MemberRepository;
import com.springbootbackend.lionspringboot.repository.MemoryMemberRepository;
import com.springbootbackend.lionspringboot.service.MemberService;


// @Configuration
public class AppConfig {

    // @Bean // 이 메서드가 반환하는 객체를 Bean으로 등록
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
