package com.lion.task.config;

import com.lion.task.repository.*;
import com.lion.task.service.*;
import org.springframework.context.annotation.Bean;

// @Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemberInMemoryRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}
