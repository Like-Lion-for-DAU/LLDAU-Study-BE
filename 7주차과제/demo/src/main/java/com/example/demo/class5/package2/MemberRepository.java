package com.example.demo.class5.package2;

import java.util.List;

import com.example.demo.class5.role.wlq;

public interface MemberRepository {

    void save(wlq member);

    wlq findByName(String name);

    List<wlq> findAll();

    boolean existsByName(String name);
}