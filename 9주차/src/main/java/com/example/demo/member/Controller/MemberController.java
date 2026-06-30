package com.example.demo.member.Controller;

import com.example.demo.member.Service.MemberService;
import com.example.demo.member.domain.Member;
import com.example.demo.member.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/")
    public ResponseEntity<?> getAllMember(){
        ArrayList<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(
                members.stream()
                        .map(MemberResponse::from)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/lions")
    public ResponseEntity<?> createLion(@RequestBody LionCreateRequest request){
        Member lion = memberService.createLion(request);
        if(lion == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(lion));
    }

    @PostMapping("/staffs")
    public ResponseEntity<?> createStaff(@RequestBody StaffCreateRequest request){
        Member staff = memberService.createStaff(request);
        if(staff == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberResponse.from(staff));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMember(@PathVariable("id") Long id){
        Member member = memberService.getMember(id);
        if(member == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(member));
    }

    @PutMapping("/lions/{id}")
    public ResponseEntity<?> updateLion(@PathVariable("id") Long id, @RequestBody LionUpdateRequest request){
        Member lion = memberService.updateLion(id, request);
        if(lion == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(lion));
    }

    @PutMapping("/staffs/{id}")
    public ResponseEntity<?> updateStaff(@PathVariable("id") Long id, @RequestBody StaffUpdateRequest request){
        Member staff = memberService.updateStaff(id, request);
        if(staff == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(MemberResponse.from(staff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id){
        boolean isDeleted = memberService.deleteMember(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
