package com.Lion.weeek6.service;

import com.Lion.weeek6.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service // 스프링 컨테이너에 서비스 빈(Bean)으로 등록합니다.
public class MemberService {

    private final MemberRepository repository;

    // 생성자 주입(DI) 방식으로 자동으로 구현체를 전달받습니다.
    @Autowired
    public MemberService(MemberRepository repository) {
        this.repository = repository; //
    }

    public void addMember(String name, String studentId, String part) {
        ArrayList<String> row = new ArrayList<>(); //
        row.add(name); //
        row.add(studentId); //
        row.add(part); //

        repository.save(row); //
    }

    // 웹 화면 응답을 위해 필터링된 회원 목록 리스트를 직접 반환하는 메서드입니다.
    public ArrayList<ArrayList<String>> getMembersByPart(String part) {
        ArrayList<ArrayList<String>> list = repository.findAll(); //
        ArrayList<ArrayList<String>> filteredList = new ArrayList<>();

        for (ArrayList<String> row : list) { //
            // 데이터 검증 후 파트명이 일치하면 리스트에 추가합니다.
            if (row.size() >= 3 && row.get(2).equals(part)) { //
                filteredList.add(row);
            }
        }
        return filteredList;
    }

    // 기존 콘솔 출력 메서드도 그대로 유지합니다.
    public void printMembersByPart(String part) {
        ArrayList<ArrayList<String>> list = repository.findAll(); //
        for (ArrayList<String> row : list) { //
            if (row.size() >= 3 && row.get(2).equals(part)) { //
                System.out.println(row); //
            }
        }
    }
}
