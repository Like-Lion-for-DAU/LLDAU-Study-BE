package com.Lion.weeek6.repository;

import java.util.ArrayList;

public class MockMemberRepository implements MemberRepository {

    @Override
    public void save(ArrayList<String> member) {
        System.out.println("Mock 저장 완료"); //
    }

    @Override
    public ArrayList<ArrayList<String>> findAll() { //
        ArrayList<ArrayList<String>> mockList = new ArrayList<>(); //

        ArrayList<String> row1 = new ArrayList<>(); //
        row1.add("서의진"); //
        row1.add("2654064"); //
        row1.add("백엔드"); //

        ArrayList<String> row2 = new ArrayList<>(); //
        row2.add("김주완"); //
        row2.add("2654063"); //
        row2.add("프론트엔드"); //

        mockList.add(row1); //
        mockList.add(row2); //

        return mockList; //
    }
}