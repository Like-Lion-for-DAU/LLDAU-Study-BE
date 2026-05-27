package com.example.demo.class5.repository;

import java.util.List;

import com.example.demo.class5.role.wlq;

public interface MemberRepository {

    void save(wlq member);

    List<wlq> findAll();

    wlq findByName(String name);

    void updateByName(String name, wlq member);

    boolean deleteByName(String name);

    boolean existsByName(String name);
}