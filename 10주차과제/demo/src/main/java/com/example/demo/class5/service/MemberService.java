package com.example.demo.class5.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.class5.domain.Member;
import com.example.demo.class5.repository.MemberRepository;
import com.example.demo.class5.global.exception.DuplicateMemberException;
import com.example.demo.class5.global.exception.MemberNotFoundException;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Member register(Member member) {
        repository.findByName(member.getName())
                .ifPresent(existingMember -> {
                    throw new DuplicateMemberException("이미 존재하는 멤버 이름입니다.");
                });

        return repository.save(member);
    }

    public Member findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public List<Member> getMembers(String part) {
        if (part == null) {
            return repository.findAll();
        }

        return repository.findByPart(part);
    }

    @Transactional
    public Member update(Long id, Member newMember) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        member.updateInfo(
                newMember.getName(),
                newMember.getMajor(),
                newMember.getPart(),
                newMember.getGeneration()
        );
        member.updateStudentId(newMember.getStudentId());
        member.updatePosition(newMember.getPosition());

        return repository.save(member);
    }

    @Transactional
    public void delete(Long id) {
        Member member = repository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException("멤버를 찾을 수 없습니다."));

        repository.delete(member);
    }
}