package com.Lion.weeek6.repository;

import java.util.ArrayList;

public interface MemberRepository {
    void save(ArrayList<String> member); //
    ArrayList<ArrayList<String>> findAll(); //
}