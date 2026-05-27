package com.springbootbackend.lionspringboot.controller;

import com.springbootbackend.lionspringboot.domain.role.Lion;
import com.springbootbackend.lionspringboot.domain.role.Role;
import com.springbootbackend.lionspringboot.domain.role.Staff;
import com.springbootbackend.lionspringboot.dto.*;
import com.springbootbackend.lionspringboot.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//메서드의 반환 값이 JSON 형태로 포맷되어 HTTP 응답 본문(Body)에 직접 작성됨
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    // 생성자 주입(생성자가 하나만 존재하므로 @Autowired 생략 가능)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // POST /members/lions  → Lion 등록
    //클라이언트로부터 수신한 JSON 데이터를 @RequestBody를 통해 Java 객체(Request DTO)로 변환.
    //이 API는 무조건 100% LionResponse 데이터만 반환
    @PostMapping("/lions")
    public ResponseEntity<LionResponse> createLion(@RequestBody LionCreateRequest request) {
        Lion lion = memberService.createLion(request);
        if (lion == null) {
            // 이름 중복 → 409 Conflict
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        // 생성 성공 → 201 Created
        return ResponseEntity.status(HttpStatus.CREATED).body(LionResponse.from(lion));
    }


    //ResponseEntity의 구조
    //HTTP 응답 메세지는 크게 세 가지 요소로 구성되며, ResponseEntity는 이 세 가지를 다룰수있음
    //상태 코드 (Status Code): 요청의 성공/실패 여부를 나타내는 3자리 숫자 (예: 200 OK, 201 Created, 404 Not Found).
    //응답 헤더 (Response Headers): 응답에 대한 메타데이터 (예: Content-Type, 인증 정보, 캐시 제어 등).
    //응답 본문 (Response Body): 클라이언트가 실제로 필요로 하는 데이터 (주로 JSON, XML, 문자열 등).


    // POST /members/staffs  → Staff 등록
    //이 API는 무조건 100% StaffResponse 데이터만 반환
    @PostMapping("/staffs")
    public ResponseEntity<StaffResponse> createStaff(@RequestBody StaffCreateRequest request) {
        Staff staff = memberService.createStaff(request);
            if (staff == null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(StaffResponse.from(staff));
    }

    // ===================== 조회 (GET) =====================

    // GET /members/{name}  → 이름으로 단일 멤버 조회
    @GetMapping("/{name}")
    public ResponseEntity<?> getMember(@PathVariable String name) {
        Role member = memberService.findByName(name);
        if (member == null) {
            // 멤버 없음 → 404 Not Found
            return ResponseEntity.notFound().build();
        }
        // 역할에 따라 응답 DTO를 다르게 반환
        if (member instanceof Lion lion) {
            return ResponseEntity.ok(LionResponse.from(lion));
        } else {
            return ResponseEntity.ok(StaffResponse.from((Staff) member));
        }
    }

    // ===================== 수정 (PUT) =====================

    // PUT /members/lions/{name}  → Lion 수정
    @PutMapping("/lions/{name}")
    public ResponseEntity<LionResponse> updateLion(
            @PathVariable String name,
            @RequestBody LionUpdateRequest request) {
        Lion lion = memberService.updateLion(name, request);
        if (lion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(LionResponse.from(lion));
    }

    // PUT /members/staffs/{name}  → Staff 수정
    @PutMapping("/staffs/{name}")
    public ResponseEntity<StaffResponse> updateStaff(
            @PathVariable String name,
            @RequestBody StaffUpdateRequest request) {
        Staff staff = memberService.updateStaff(name, request);
        if (staff == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(StaffResponse.from(staff));
    }

    // ===================== 삭제 (DELETE) =====================

    // DELETE /members/{name}  → 멤버 삭제
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteMember(@PathVariable String name) {
        boolean deleted = memberService.deleteMember(name);
        if (!deleted) {
            return ResponseEntity.notFound().build();   // 404
        }
        return ResponseEntity.noContent().build();       // 204 No Content
    }
}