//package com.springbootbackend.lionspringboot.config;
//
//
//
//
//// import org.springframework.context.annotation.Bean;
//// import org.springframework.context.annotation.Configuration;
//
//import com.springbootbackend.lionspringboot.repository.MemberRepository;
//
//import com.springbootbackend.lionspringboot.service.MemberService;
//
///**
// * [수동 주입 방식 - 학습용 보존]
// *
// * 5주차 Main.java에서 직접 new로 객체를 생성하고 조립했던 것을
// * @Configuration + @Bean 으로 옮긴 형태입니다.
// *
// * 현재는 자동 주입(@Service, @Repository)으로 전환했으므로
// * @Configuration 어노테이션을 주석 처리해 비활성화했습니다.
// *
// * - 5주차 (Main.java에서 직접 조립)
// *      → 수동 주입 (AppConfig에서 조립)
// *      → 자동 주입 (스프링이 알아서 조립)
// *
// * 객체 생성은 여전히 개발자가 하지만(@Bean 메서드 안 new),
// * 관리는 스프링 컨테이너가 맡는다는 점이 5주차와의 차이입니다.
// */
//// @Configuration
//public class AppConfig {
//
//    // @Bean // 이 메서드가 반환하는 객체를 Bean으로 등록
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
//
//    // @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }
//}
