package com.Lion.weeek6.repository;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository // 컴포넌트 스캔을 이용한 "자동 주입" 활성화
public class MemoryMemberRepository implements MemberRepository {

    private final ArrayList<ArrayList<String>> list = new ArrayList<>(); //

    @Override
    public void save(ArrayList<String> member) { //
        list.add(member); //
    }

    @Override
    public ArrayList<ArrayList<String>> findAll() {
        return list; //
    }
}