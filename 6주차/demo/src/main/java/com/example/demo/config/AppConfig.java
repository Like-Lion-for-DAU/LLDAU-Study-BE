package com.example.demo.config;

import com.example.demo.MemberRepository;
import com.example.demo.MemoryMemberRepository;
import com.example.demo.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스프링의 설정 정보(설정 클래스)로 지정
public class AppConfig {

    @Bean // 스프링 컨테이너에 Bean으로 수동 등록
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        // 생성자를 통해 MemoryMemberRepository 객체를 수동으로 주입.
        return new MemberService(memberRepository());
    }
}