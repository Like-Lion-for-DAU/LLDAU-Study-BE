package com.Lion.weeek6.controller;

import com.Lion.weeek6.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    // 생성자 주입(DI) 방식으로 스프링이 자동으로 MemberService를 조립해 줍니다.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 6주차 과제 요구사항: 첫 REST API ('/hello')
    // 테스트 주소: http://localhost:8080/api/members/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    // 멤버 추가 API (Query Parameter 활용)
    // 테스트 주소: http://localhost:8080/api/members/add?name=서의진&studentId=2654064&part=백엔드
    @PostMapping("/add")
    public String addMember(
            @RequestParam String name,
            @RequestParam String studentId,
            @RequestParam String part) {
        memberService.addMember(name, studentId, part);
        return "스프링 부트 저장소에 등록 완료: " + name;
    }

    // 파트별 멤버 조회 API (JSON 배열 형식으로 브라우저 화면에 반환)
    // 테스트 주소: http://localhost:8080/api/members/search/백엔드
    @GetMapping("/search/{part}")
    public ArrayList<ArrayList<String>> getMembersByPart(@PathVariable String part) {
        return memberService.getMembersByPart(part);
    }
}