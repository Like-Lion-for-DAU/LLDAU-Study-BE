package com.Lion.weeek6.config;

import com.Lion.weeek6.repository.MemberRepository;
import com.Lion.weeek6.repository.MemoryMemberRepository;
import com.Lion.weeek6.repository.MockMemberRepository;
import com.Lion.weeek6.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        // 이 공장 메서드의 반환 생성자만 바꿈으로써 프로그램 전체 저장 장치를 통제할 수 있습니다(IoC).
        return new MemoryMemberRepository();
        // return new MockMemberRepository(); // <- Mock 데이터를 보고 싶다면 이 코드의 주석을 푸세요!
    }

    @Bean
    public MemberService memberService() {
        // 생성자 수동 DI 구현: 정의된 memberRepository 빈을 주입하여 서비스를 생성합니다.
        return new MemberService(memberRepository());
    }
}
*/