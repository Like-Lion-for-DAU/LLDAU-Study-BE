package com.example.demo.class5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.class5.domain.Member;
import com.example.demo.class5.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public Member register(Member member) {
        return repository.save(member);
    }

    public Member findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member update(Long id, Member newMember) {
        Member member = repository.findById(id).orElse(null);

        if (member == null) {
            return null;
        }

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

    public void delete(Long id) {
        repository.deleteById(id);
    }
}