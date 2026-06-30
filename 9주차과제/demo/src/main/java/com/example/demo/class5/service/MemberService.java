package com.example.demo.class5.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.class5.domain.Member;
import com.example.demo.class5.repository.MemberRepository;

@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Member register(Member member) {
        return repository.save(member);
    }

    public Member findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    @Transactional
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

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}