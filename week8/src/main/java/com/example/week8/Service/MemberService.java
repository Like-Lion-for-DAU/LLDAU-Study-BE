package com.example.week8.service;

import com.example.week8.domain.Member;
import com.example.week8.domain.RoleType;
import com.example.week8.dto.*;
import com.example.week8.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    // 생성
    public Member createLion(LionCreateRequest request) {

        Member member = new Member(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                RoleType.LION,
                request.getStudentId(),
                null
        );

        return repository.save(member);
    }

    public Member createStaff(StaffCreateRequest request) {

        Member member = new Member(
                request.getName(),
                request.getMajor(),
                request.getGeneration(),
                request.getPart(),
                RoleType.STAFF,
                null,
                request.getPosition()
        );

        return repository.save(member);
    }

    // 전체조회
    public List<Member> findAll() {
        return repository.findAll();
    }

    // 단건조회
    public Member findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 수정
    public Member updateLion(Long id, LionUpdateRequest request) {

        Member member = repository.findById(id).orElse(null);

        if (member == null) {
            return null;
        }

        member.updateInfo(
                request.getMajor(),
                request.getGeneration(),
                request.getPart()
        );

        member.updateStudentId(request.getStudentId());

        return repository.save(member);
    }

    public Member updateStaff(Long id, StaffUpdateRequest request) {

        Member member = repository.findById(id).orElse(null);

        if (member == null) {
            return null;
        }

        member.updateInfo(
                request.getMajor(),
                request.getGeneration(),
                request.getPart()
        );

        member.updatePosition(request.getPosition());

        return repository.save(member);
    }

    // 삭제
    public void deleteMember(Long id) {
        repository.deleteById(id);
    }
}